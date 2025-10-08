/**
  Object representing a single graded component.
  param AssignmentName
  param weight weighted in [0, 100] (not required to sum to 1 across entries; see GradeBook)
  param score  percentage in [0, 100]
 */
public record Grade(String AssignmentName, double weight, double score) {

    public Grade {
        if (AssignmentName == null || AssignmentName.isBlank()) {
            throw new IllegalArgumentException("name must be non-blank");
        }
        if (Double.isNaN(weight) || weight < 0.0 || weight >= 100.0) {
            throw new IllegalArgumentException("weight must be in [0,100]");
        }
        if (Double.isNaN(score) || score < 0.0 || score > 100.0) {
            throw new IllegalArgumentException("score must be in [0,100]");
        }
    }

    /* new entry with updated score (validates bounds). */
    public Grade withScore(double newScore) {
        return new Grade(this.AssignmentName, this.weight, newScore);
    }

    /* new entry with updated weight (validates bounds). */
    public Grade withWeight(double newWeight) {
        return new Grade(this.AssignmentName, newWeight, this.weight);
    }
    @Override
    public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Grade other)) return false;
	    return this.AssignmentName.toLowerCase().equals(other.AssignmentName.toLowerCase())
            	&& this.weight == other.weight
            	&& this.score == other.score;
    }

    public boolean isPerfect() {
        return this.score == 100.0;
    }
}
