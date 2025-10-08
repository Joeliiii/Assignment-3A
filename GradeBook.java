import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * GradeBook holds a list of Grade items and computes final numeric and letter grades.
 * Weights are given in 0–100. You can either:
 * Normalize weights to sum to 100 (recommended), or require they already sum to ~100.
 */
public class GradeBook {

    private final List<Grade> entries = new ArrayList<>();


    private Double cachedAverage = null;

    public int indexOfByName(String name) {
	    	if (name == null) return -1;
	    	for (int i = 0; i < entries.size(); i++) {
            		if (entries.get(i).AssignmentName().toLowerCase().equals(name.toLowerCase())) {
                		return i;
            		}
        	}
        	return -1;
    }


    public void addGrade(String name, double weight, double score) {
        entries.add(new Grade(name, weight, score));
    }

    public Grade updateScore(int index, double newScore) {
        Grade updated = entries.get(index).withScore(newScore);
        entries.set(index, updated);
        return updated;
    }

    public Grade updateWeight(int index, double newWeight) {
        Grade updated = entries.get(index).withWeight(newWeight);
        entries.set(index, updated);
        return updated;
    }

    public Grade remove(int index) {
        return entries.remove(index);
    }

    public void clear() {
        entries.clear();
    }

    public int size() {
        return entries.size();
    }

    public List<Grade> getEntries() {
        return Collections.unmodifiableList(entries);
    }

    public double weightSum() {
        return entries.stream().mapToDouble(Grade::weight).sum();
    }

    /**
     * @param normalizeIfNeeded if true, weights are normalized to sum to 100.
     * @return final numeric grade [0–100]
     */
    
    public double calculateFinal(boolean normalizeIfNeeded) {
    
	if (cachedAverage != null) return cachedAverage;

	if (entries.isEmpty()) return 0.0;

        double sumW = weightSum();
        if (normalizeIfNeeded) {
            if (sumW <= 0.0) throw new IllegalStateException("Cannot normalize when total weight is 0.0");
            double total = 0.0;
            for (Grade g : entries) {
                total += g.score() * (g.weight() / sumW);
            }
	    cachedAverage = total;
            return total;
        } else {
            if (Math.abs(sumW - 100.0) > 1e-6) {
                throw new IllegalStateException("Weights must sum to 100 (±1e-6); got " + sumW);
            }
            double total = 0.0;
            for (Grade g : entries) {
                total += g.score() * (g.weight() / 100.0);
            }
	    cachedAverage = total;
            return total;
        }
    }

    public String toLetter(double numeric) {
        if (numeric >= 90.0) return "A";
        if (numeric >= 80.0) return "B";
        if (numeric >= 70.0) return "C";
        if (numeric >= 60.0) return "D";
        return "F";
    }

    public String finalLetterNormalized() {
        return toLetter(calculateFinal(true));
    }

    public void validate() {
        for (Grade g : entries) Objects.requireNonNull(g, "entry");
    }
}
