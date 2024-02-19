import java.rmi.Remote;
import java.rmi.RemoteException;

    public interface Account extends Remote {
        double getBalance() throws RemoteException;
        void deposit(double amount) throws RemoteException;
        void withdraw(double amount) throws RemoteException;
    }


