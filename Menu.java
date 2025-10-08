import java.util.Scanner;

/**
 * Console menu for GradeBook using the Grade record.
 * Allows adding, listing, updating, removing, and computing grades.
 */
public class Menu {

    public static void main(String[] args) {
        GradeBook gb = new GradeBook();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Student Grade Calculator ---");
                System.out.println("1) Add grade");
                System.out.println("2) List grades");
                System.out.println("3) Calculate final (normalized to 100)");
                System.out.println("4) Update weight");
                System.out.println("5) Update score");
                System.out.println("6) Remove entry");
                System.out.println("7) Clear all");
                System.out.println("0) Exit");
                System.out.print("Choose: ");
                String choice = sc.nextLine().trim();

                switch (choice) {
                    case "1" -> addGradeFlow(gb, sc);
                    case "2" -> list(gb);
                    case "3" -> calc(gb);
                    case "4" -> updateWeightFlow(gb, sc);
                    case "5" -> updateScoreFlow(gb, sc);
                    case "6" -> removeFlow(gb, sc);
                    case "7" -> { gb.clear(); System.out.println("Cleared."); }
                    case "0" -> { System.out.println("Bye!"); return; }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }

    private static void addGradeFlow(GradeBook gradeBook, Scanner scanner) {
        System.out.print("Assignment name: ");
        String name = scanner.nextLine().trim();
	if (name.isEmpty()) name = null;	
        System.out.print("Weight (0–100): ");
        double w = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Weight (0–100): ");
        double s = Double.parseDouble(scanner.nextLine().trim());
        gradeBook.addGrade(name, w, s);
        System.out.println("Added.");
    }

    private static void list(GradeBook gradeBook) {
        if (gradeBook.size() == 0) {
            System.out.println("(no entries)");
            return;
        }
        for (int i = 0; i < gradeBook.size(); i++) {
	    int display = i + 1;
            Grade g = gradeBook.getEntries().get(i);
            System.out.printf("%d) %-20s weight=%.2f score=%.2f%n",
                    display, g.AssignmentName(), g.weight(), g.score());
        }
        System.out.printf("Weight sum: %.2f%n", gradeBook.weightSum());
    }

    private static void calc(GradeBook gradeBook) {
        try {
            double finalPct = gradeBook.calculateFinal(true);
            System.out.printf("Final (normalized): %.2f%% -> %s%n",
                    finalPct, gradeBook.toLetter(finalPct));
        } catch (IllegalStateException ex) {
            System.out.println("Cannot compute: " + ex.getMessage());
        }
    }

    private static void updateWeightFlow(GradeBook gradeBook, Scanner scanner) {
        list(gradeBook);
        if (gradeBook.size() == 0) return;
        System.out.print("Index to update: ");
        int idx = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("New weight (0–100): ");
        double w = Double.parseDouble(scanner.nextLine().trim());
        gradeBook.updateWeight(idx, w);
        System.out.println("Updated.");
    }

    private static void updateScoreFlow(GradeBook gradeBook, Scanner scanner) {
        list(gradeBook);
        if (gradeBook.size() == 0) return;
        System.out.print("Index to update: ");
        int idx = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("New score (0–100): ");
        double s = Double.parseDouble(scanner.nextLine().trim());
        gradeBook.updateScore(idx, s);
        System.out.println("Updated.");
    }

    private static void removeFlow(GradeBook gradeBook, Scanner scanner) {
        list(gradeBook);
        if (gradeBook.size() == 0) return;
        System.out.print("Index to remove: ");
        int idx = Integer.parseInt(scanner.nextLine().trim());
        gradeBook.remove(idx);
        System.out.println("Removed.");
    }
}
