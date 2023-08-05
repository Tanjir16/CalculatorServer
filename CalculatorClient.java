import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.Scanner;

public class CalculatorClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1091);
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            Scanner scanner = new Scanner(System.in);

            // Read input values from the user
            System.out.print("Enter value 1: ");
            int value1 = scanner.nextInt();

            System.out.print("Enter value 2: ");
            int value2 = scanner.nextInt();

            // Push values onto the stack
            calculator.pushValue(value1);
            calculator.pushValue(value2);

            // Push "LCM" operation and get the result
            calculator.pushLCM();
            System.out.println("Least Common Multiple (LCM): " + calculator.pop());

            // Push "GCD" operation and get the result
            calculator.pushGCD();
            System.out.println("Greatest Common Divisor (GCD): " + calculator.pop());

            Random random = new Random();

            System.out.println("\nGenerated random values:");

            // Push 10 random values onto the stack
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
