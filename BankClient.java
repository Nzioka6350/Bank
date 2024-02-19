import java.rmi.Naming;
import java.util.Scanner;

public class BankClient {
    public static void main(String[] args) {
        try {
            // Look up the remote object
            Account bankAccount = (Account) Naming.lookup("rmi://localhost:1099/BankAccount");

            // Create a scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Perform transactions
            System.out.println("Current Balance: " + bankAccount.getBalance());

            // Ask user for deposit amount
            System.out.print("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();
            bankAccount.deposit(depositAmount);
            System.out.println("New Balance after deposit: " + bankAccount.getBalance());

            // Ask user for withdrawal amount
            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();
            bankAccount.withdraw(withdrawalAmount);
            System.out.println("New Balance after withdrawal: " + bankAccount.getBalance());

            // Close the scanner
            scanner.close();
        } catch (java.rmi.ConnectException connectException) {
            System.err.println("Error: Unable to connect to the server. Please make sure the server is running.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
