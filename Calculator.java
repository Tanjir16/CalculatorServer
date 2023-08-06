import java.rmi.Remote;
import java.rmi.RemoteException;
// Have Define a remote interface named "Calculator"
public interface Calculator extends Remote {
    // Made Method to push a value onto the calculator's stack
    void pushValue(int value) throws RemoteException;
    //Made Method to push an operation onto the calculator's stack
    void pushOperation(String operation) throws RemoteException;
     // Made Method to pop and retrieve the top value from the calculator's stack
    int pop() throws RemoteException;
    // Made Method to check if the calculator's stack is empty
    boolean isEmpty() throws RemoteException;
    // Made Method to delay pop and retrieve a value from the calculator's stack after a delay
    int delayPop(int millis) throws RemoteException;
    // Made Method to push an operation for finding the Least Common Multiple onto the calculator's stack
    void pushLCM() throws RemoteException;
     // Made Method to push an operation for finding the Greatest Common Divisor onto the calculator's stack
    void pushGCD() throws RemoteException;
}
