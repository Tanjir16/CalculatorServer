import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {

    public static void main(String[] args) {
        try {
            // Create the CalculatorImplementation object
            CalculatorImplementation calculator = new CalculatorImplementation();

            // Bind the CalculatorImplementation object to the RMI registry
            Registry registry = LocateRegistry.createRegistry(1091);
            registry.bind("CalculatorService", calculator);

            System.out.println("Calculator Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}