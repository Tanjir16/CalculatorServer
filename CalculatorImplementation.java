import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;
// CalculatorImplementation class implements the Calculator interface and provides its functionality
public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    private Stack<Integer> stack;
    // Constructor initializes the stack
    public CalculatorImplementation() throws RemoteException {
        super();
        stack = new Stack<>();
    }
    // Pushes a value onto the stack
    public void pushValue(int value) throws RemoteException {
        stack.push(value);
    }
     // Pushes an operation onto the stack (e.g., "min" or "max")

    public void pushOperation(String operation) throws RemoteException {
        if (operation.equals("min")) {
            // Implementation for minimum value
        } else if (operation.equals("max")) {
            // Implementation for maximum value
        } else {
            // Handle other operations
        }
    }
    // Pops and returns the top value from the stack
    public int pop() throws RemoteException {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return -1; // Return -1 to indicate an empty stack
    }
    // Checks if the stack is empty
    public boolean isEmpty() throws RemoteException {
        return stack.isEmpty();
    }
     // Delays and then pops a value from the stack
    public int delayPop(int millis) throws RemoteException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return -1; // Return -1 to indicate an empty stack
    }
    // It Pushes the Least Common Multiple of two top values onto the stack

    public void pushLCM() throws RemoteException {
        if (stack.size() < 2) {
            return; // LCM requires at least two values
        }
        int value2 = stack.pop();
        int value1 = stack.pop();
        int lcm = calculateLCM(value1, value2);
        stack.push(lcm);
    }
    // It Pushes the Greatest Common Divisor of two top values onto the stack
    public void pushGCD() throws RemoteException {
        if (stack.size() < 2) {
            return; // GCD requires at least two values
        }
        int value2 = stack.pop();
        int value1 = stack.pop();
        int gcd = calculateGCD(value1, value2);
        stack.push(gcd);
    }

    // Made method to calculate the least common multiple
    private int calculateLCM(int a, int b) {
        int lcm = (a * b) / calculateGCD(a, b);
        return lcm;
    }

    // Made method to calculate the greatest common divisor
    private int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }
}
