# Calculator RMI Project

This project is based on a Simple Calculator application using Java's Remote method Invocation (RMI). 

- `CalculatorServer.java`: This file contains the main class for the RMI server. It creates an instance of `CalculatorImplementation`, binds it to the RMI registry, and starts the server to listen for incoming client requests.

- `CalculatorImplementation.java`: This file implements the `Calculator` interface and provides the core functionality of the calculator. It manages individual stacks for each client, handles basic arithmetic operations (push value, push LCM, push GCD, push Min, push Max, pop), and maintains a mapping of client IP addresses to their respective stacks.

- `CalculatorClient.java`: This file represents the RMI client application. It connects to the RMI server, generates random values for calculations, and performs various operations such as pushing values onto the stack, calculating LCM and GCD, popping values, and more. Each client operation is associated with a unique Client ID, allowing for distinct stack management.

- `CalculatorTest.java`: This file contains a test class for running multiple instances of the `CalculatorClient` and simulating different client interactions. It demonstrates the concurrent nature of the application and showcases how each client maintains its own stack.

## Prerequisites

- Java Development Kit (JDK) installed
- Basic understanding of RMI (Remote Method Invocation)
- git



## Features

- Perform basic arithmetic operations (push value, push LCM, push GCD, Push Min & Max, pop values).
- Each client has its own stack on the server.
- Display results with the respective Client ID.

## Getting Started

Clone the repository: https://github.com/Tanjir16/calculatorServer.git

1. Compile the code: 'javac *.java'  
2. Run the server: 'java CalculatorServer'
3. Run multiple client instances: 'java CalculatorClient'
4. Testing for many Clients : 'java CalculatorTest'

## Supported Operations

The Calculator RMI project supports the following operations:

- Push a value onto the client's stack.
- Push the Least Common Multiple (LCM) of two top values onto the client's stack.
- Push the Greatest Common Divisor (GCD) of two top values onto the client's stack.
- Push the minimum value from the top two values on the client's stack.
- Push the maximum value from the top two values on the client's stack.
- Pop and retrieve the top value from the client's stack.
- Check if the client's stack is empty.
- Delayed pop from the client's stack.

Each operation is associated with a unique Client ID, ensuring separate stack management for each client.

## Client Operations

The code begins by importing necessary classes and packages, including those related to reading files, RMI (Remote Method Invocation), networking, and arrays.

Main Method: The program's main execution starts in the main method.

RMI Setup:

It creates an instance of the Registry class by calling LocateRegistry.getRegistry("localhost", 1091). This is used to locate the RMI registry on the localhost at port 1091.
It retrieves the remote Calculator object from the registry using the lookup method.
Random Number Generator: A Random object is created, which will be used later for generating random numbers.

Client IP Address:

The client's IP address is obtained using InetAddress.getLocalHost().getHostAddress().
A string with the client's IP address is created and displayed as "Client ID: [IP Address]" using System.out.println.
Reading Input Values:

The program reads input values from a file named "input.txt" using a BufferedReader.
It reads each line from the file and converts it to an integer using Integer.parseInt(line).
The obtained integer value is then pushed onto the calculator's stack using the pushValue method.
Reading Expected Output Values:

Similar to reading input values, the program reads expected output values from a file named "expected_output.txt" using a BufferedReader.
It reads each line from the file and displays it as "Expected Output: [line]" using System.out.println.
Closing Files: After reading input and expected output values, the input and expected output files are closed using the close method on the BufferedReader objects.

## Testing Values : - 

The Input Values :    
50
10
15
26
41
34
22
17
28
6

The Expected Output :
936
1
59
13
82
12
15
26
41
34
22
17
28
6
## How to Use

1. Start the RMI server by running `java CalculatorServer`.
2. Run multiple instances of the RMI client application `java CalculatorClient` to simulate different clients.
3. Each client will generate random values and perform various stack operations.
4. The output will display the Client ID, generated values, and the results of the operations, providing a clear overview of each client's stack and calculations.
5. For testing concurrent interactions, you can also run `java CalculatorTest` to see how multiple clients interact with the server simultaneously.