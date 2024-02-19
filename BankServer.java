import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BankServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the remote object
            Account bankAccount = new BankAccount();

            // Create and start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry
            Naming.rebind("BankAccount", bankAccount);

            System.out.println("BankAccount server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
