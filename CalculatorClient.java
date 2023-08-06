import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.net.InetAddress;
import java.util.Arrays; 

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

            // Read input values from a file
            BufferedReader inputFile = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = inputFile.readLine()) != null) {
                int value = Integer.parseInt(line);
                calculator.pushValue(value);
            }
            inputFile.close();

            // Read expected output values from a file
            BufferedReader expectedOutputFile = new BufferedReader(new FileReader("expected_output.txt"));
            String expectedLine;
            while ((expectedLine = expectedOutputFile.readLine()) != null) {
                System.out.println("Expected Output: " + expectedLine);
            }
            expectedOutputFile.close();

        
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
