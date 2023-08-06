import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.net.InetAddress;
import java.rmi.RemoteException;

public class CalculatorClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1091);
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            Random random = new Random();

            // Get the client's IP address
            String clientIP = InetAddress.getLocalHost().getHostAddress();
            String clientID = "Client ID: " + clientIP;
            System.out.println(clientID);

            // First I Generated random values for LCM and GCD
            int value1 = random.nextInt(100) + 1; // Generates a random integer between 1 and 100
            int value2 = random.nextInt(100) + 1;

            // Then it Push values onto the stack
            calculator.pushValue(value1);
            calculator.pushValue(value2);

            // Also Push LCM operation and get the result
            calculator.pushLCM();
            System.out.println("Generated value 1 for LCM: " + value1);
            System.out.println("Generated value 2 for LCM: " + value2);
            System.out.println("Least Common Multiple (LCM): " + calculator.pop());

            // Then it Pushes GCD operation and get the result
            calculator.pushGCD();
            System.out.println("Generated value 1 for GCD: " + value1);
            System.out.println("Generated value 2 for GCD: " + value2);
            System.out.println("Greatest Common Divisor (GCD): " + calculator.pop());

            // Generate and push 10 random values onto the stack
            System.out.println("\nGenerated random values for client:");
            for (int i = 0; i < 10; i++) {
                int randomValue = random.nextInt(100); // Generates a random integer between 0 and 99
                calculator.pushValue(randomValue);
                System.out.print(randomValue + " "); // Print each value with a space separator
            }

            // Check if the stack is empty
            if (calculator.isEmpty()) {
                System.out.println("\nStack is empty.");
            } else {
                System.out.println("\nStack is not empty.");
            }

            // Delayed pop from the stack
            int delayedValue = calculator.delayPop(1000); // Delay for 1 second
            System.out.println("Delayed popped value: " + delayedValue);

            // Push "min" operation and get the result
            calculator.pushOperation("min");
            System.out.println("Minimum value: " + calculator.pop());

            // Push "max" operation and get the result
            calculator.pushOperation("max");
            System.out.println("Maximum value: " + calculator.pop());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
