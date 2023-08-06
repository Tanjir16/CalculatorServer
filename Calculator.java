import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    void pushValue(int value) throws RemoteException;
    void pushOperation(String operation) throws RemoteException;
    int pop() throws RemoteException;
    boolean isEmpty() throws RemoteException;
    int delayPop(int millis) throws RemoteException;
    void pushLCM() throws RemoteException;
    void pushGCD() throws RemoteException;

    // Methods
    int calculateLCM(int a, int b) throws RemoteException;
    int calculateGCD(int a, int b) throws RemoteException;
    int calculateMin(int a, int b) throws RemoteException;
    int calculateMax(int a, int b) throws RemoteException;
}
