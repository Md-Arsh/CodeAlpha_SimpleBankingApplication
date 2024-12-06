import java.util.Scanner;

public class SimpleBankingApplication {
    private double balance;

    public SimpleBankingApplication() {
        this.balance = 0.0;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount. Deposit must be greater than 0.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: $" + balance);
        } else {
            System.out.println("Invalid amount. Withdrawal must be greater than 0.");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleBankingApplication bankApp = new SimpleBankingApplication();

        System.out.println("Welcome to the Simple Banking Application!");

        while (true) {
            // Display menu
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    // Deposit
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    bankApp.deposit(depositAmount);
                }

                case 2 -> {
                    // Withdraw
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    bankApp.withdraw(withdrawAmount);
                }

                case 3 -> // Check Balance
                    bankApp.checkBalance();

                case 4 -> {
                    // Exit
                    System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
                    scanner.close();
                    return;
                }

                default -> // Invalid input
                    System.out.println("Invalid choice. Please choose an option between 1 and 4.");
            }
        }
    }
}
