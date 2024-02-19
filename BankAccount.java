import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankAccount extends UnicastRemoteObject implements Account {
    private double balance;

    public BankAccount() throws RemoteException {
        // Initialize balance to zero
        balance = 0.0;
    }

    @Override
    public double getBalance() throws RemoteException {
        return balance;
    }

    @Override
    public void deposit(double amount) throws RemoteException {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) throws RemoteException {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}