package Q1L1;

import java.util.Scanner;

public class TestingExecutionTime {

    public static void main(String[] args) {
        //create scanner for user input
        Scanner scanner = new Scanner(System.in);

        //invoke header method with argument 1
        myHeader(1);

        //ask user for input
        int n;
        do {
            System.out.print("Enter an integer number: ");
            n = scanner.nextInt();
        } while (n < 0); //make sure that number is either 0 or positive

        // create and call iterative solution and method for the first time
        double startTime = System.nanoTime(); //activate System.nanoTime()
        double iterativeResult1 = iterativeMethodForFactorial(n);
        double endTime = System.nanoTime();
        double iterativeExecutionTime = (endTime - startTime) / 1e9;
        System.out.printf("Factorial (" + n + ") is %.0e%n", iterativeResult1);
        System.out.printf("Time taken by iterative solution inside main: %.2e sec%n", iterativeExecutionTime);

        // create and call iterative solution and method for the second time
        startTime = System.nanoTime(); //activate System.nanoTime()
        double iterativeResult2 = iterativeMethodForFactorial(n);
        endTime = System.nanoTime();
        iterativeExecutionTime = (endTime - startTime) / 1e9;
        System.out.printf("Factorial (" + n + ") with iterative method is %.0e%n", iterativeResult2);
        System.out.printf("Time taken by iterative method call: %.2e sec%n", iterativeExecutionTime);

        // create and call recursive solution and method
        startTime = System.nanoTime(); //activate System.nanoTime()
        double recursiveResult = recursiveMethodFactorial(n);
        endTime = System.nanoTime();
        double recursiveExecutionTime = (endTime - startTime) / 1e9;
        System.out.printf("Factorial (" + n + ") with recursive call is %.0e%n", recursiveResult);
        System.out.printf("Time taken by recursive method call: %.2e sec%n", recursiveExecutionTime);

        //invoke footer method with argument 1
        myFooter(1);
    }

    //create header method
    public static void myHeader(int questionNumber) {
        //print header
        System.out.println("=======================================================");
        System.out.println("Lab Exercise 1" + "-Q" + questionNumber);
        System.out.println("Prepared by: Carson Yuen");
        System.out.println("Student Number: " + 251295214);
        System.out.println("Goal of this Exercise: Checking the code-execution time!");
        System.out.println("=======================================================");
    }

    //create footer method
    public static void myFooter(int questionNumber) {
        //print footer
        System.out.println("=======================================================");
        System.out.println("Completion of Lab Exercise 1" + "-Q" + questionNumber +" is successful!");
        System.out.println("Signing off - Carson Yuen");
        System.out.println("=======================================================");
    }

    // iterative approach to calculate factorial
    public static double iterativeMethodForFactorial(int n) {
        double result = 1;
        int i = 1;
        while (i <= n) {
            result = result * i;
            i++;
        }
        return result;}

    //recursive method to calculate factorial
    public static double recursiveMethodFactorial(int n){
        if (n == 0) {
            return 1;
        }
        else {
            return n*recursiveMethodFactorial(n-1);
        }
        }
    }
