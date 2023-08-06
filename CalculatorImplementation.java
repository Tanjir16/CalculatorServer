import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.net.InetAddress;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    private Map<String, Stack<Integer>> clientStacks; // Map to store client stacks

    public CalculatorImplementation() throws RemoteException {
        super();
        clientStacks = new HashMap<>();
    }

    private Stack<Integer> getClientStack() {
        String clientIP = "";
        try {
            clientIP = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientStacks.computeIfAbsent(clientIP, k -> new Stack<>());
    }

    public void pushValue(int value) throws RemoteException {
        getClientStack().push(value);
    }

    public void pushOperation(String operation) throws RemoteException {
        if (operation.equals("min")) {
            // Implementation for minimum value
        } else if (operation.equals("max")) {
            // Implementation for maximum value
        } else {
            // Handle other operations
        }
    }

    public int pop() throws RemoteException {
        Stack<Integer> stack = getClientStack();
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return -1;
    }

    public boolean isEmpty() throws RemoteException {
        Stack<Integer> stack = getClientStack();
        return stack.isEmpty();
    }

    public int delayPop(int millis) throws RemoteException {
        Stack<Integer> stack = getClientStack();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return -1;
    }

    public void pushLCM() throws RemoteException {
        Stack<Integer> stack = getClientStack();
        if (stack.size() < 2) {
            return;
        }
        int value2 = stack.pop();
        int value1 = stack.pop();
        int lcm = calculateLCM(value1, value2);
        stack.push(lcm);
    }

    public void pushGCD() throws RemoteException {
        Stack<Integer> stack = getClientStack();
        if (stack.size() < 2) {
            return;
        }
        int value2 = stack.pop();
        int value1 = stack.pop();
        int gcd = calculateGCD(value1, value2);
        stack.push(gcd);
    }

    public int calculateLCM(int a, int b) throws RemoteException {
        int lcm = (a * b) / calculateGCD(a, b);
        return lcm;
    }

    public int calculateGCD(int a, int b) throws RemoteException {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

    public int calculateMin(int a, int b) throws RemoteException {
        return Math.min(a, b);
    }

    public int calculateMax(int a, int b) throws RemoteException {
        return Math.max(a, b);
    }
}
