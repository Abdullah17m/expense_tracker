import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTrackerCLI {

    private List<String> categories;
    private List<String> expenses;
    private Scanner scanner;

    public ExpenseTrackerCLI() {
        categories = new ArrayList<>();
        expenses = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Expense Tracker CLI!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Category");
            System.out.println("2. Add Expense");
            System.out.println("3. View Expenses");
            System.out.println("4. Exit");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addCategory();
                    break;
                case 2:
                    addExpense();
                    break;
                case 3:
                    viewExpenses();
                    break;
                case 4:
                    System.out.println("Exiting Expense Tracker CLI. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addCategory() {
        System.out.print("Enter category name: ");
        String category = scanner.nextLine();
        categories.add(category);
        System.out.println("Category '" + category + "' added successfully.");
    }

    private void addExpense() {
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();

        System.out.print("Select category:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
        int categoryIndex = getIntInput() - 1;
        if (categoryIndex < 0 || categoryIndex >= categories.size()) {
            System.out.println("Invalid category selection.");
            return;
        }
        String category = categories.get(categoryIndex);

        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        expenses.add("Category: " + category + ", Description: " + description + ", Amount: $" + amount);
        System.out.println("Expense added successfully.");
    }

    private void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("Expenses:");
            for (String expense : expenses) {
                System.out.println("- " + expense);
            }
        }
    }

    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static void main(String[] args) {
        ExpenseTrackerCLI expenseTrackerCLI = new ExpenseTrackerCLI();
        expenseTrackerCLI.start();
    }
}

