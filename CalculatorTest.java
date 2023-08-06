import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    public static void main(String[] args) {
        final int numClients = 5; // Number of client instances to run

        // Create a thread pool to run multiple clients concurrently
        ExecutorService executor = Executors.newFixedThreadPool(numClients);

        // Run multiple CalculatorClient instances concurrently
        for (int i = 0; i < numClients; i++) {
            executor.submit(() -> runClient());
        }

        // Shutdown the executor
        executor.shutdown();

        try {
            // Wait for all tasks to complete
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void runClient() {
        try {
            CalculatorClient.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
