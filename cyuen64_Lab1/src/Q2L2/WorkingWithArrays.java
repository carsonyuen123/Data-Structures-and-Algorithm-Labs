package Q2L2;

import java.util.Scanner;

public class WorkingWithArrays {

    //create scanner for user input
    public static Scanner WorkingWithArrays = new Scanner(System.in);

    //define static method
    public static double[] mma5MethodCarson(double[] myArray) {
        //declare variables
        int count = 0;
        double sum = 0;
        double maxValue = Double.NEGATIVE_INFINITY;
        double minValue = Double.POSITIVE_INFINITY;

        for (double num : myArray) {
            if (num % 5 == 0) {
                count++; //count the number of numbers divisible by 5
                sum += num; //add up numbers divisible by 5
                maxValue = Math.max(maxValue, num); //obtain max value
                minValue = Math.min(minValue, num); //obtain min value
            }
        }
        System.out.println("\nHere is the result... \n");

        //declare variable averageValue, and give it parameters depending if count is 0 or not
        double averageValue;
        if (count == 0) {
            averageValue = 0.00; //return average value
        } else {
            averageValue = sum/count;
        }

        //print two different outputs depending on if there are numbers divisible by 5 or not, shown in the samples
        if (count > 0 ) {
            System.out.println("Carson found " + count + " numbers that are divisible-by-5.");
        } else
            System.out.println("In the array, there was no number 'divisible by 5' and hence the average remains 0.00.");

        return new double[]{maxValue, minValue, averageValue, 251295214}; //return double type reference of array
    }

    public static void myHeader(int questionNumber) {
        //print header
        System.out.println("=======================================================");
        System.out.println("Lab Exercise 1" + "-Q" + questionNumber);
        System.out.println("Prepared by: Carson Yuen");
        System.out.println("Student Number: " + 251295214);
        System.out.println("Goal of this Exercise: Working with arrays and conditional statements!");
        System.out.println("=======================================================");
    }

    public static void myFooter(int questionNumber) {
        //print footer
        System.out.println("=======================================================");
        System.out.println("Completion of Lab Exercise 1" + "-Q" + questionNumber + " is successful!");
        System.out.println("Signing off - Carson Yuen");
        System.out.println("=======================================================");
    }

    public static void main(String[] args) {
        //call header
        myHeader(2);

        System.out.print("Enter array size: ");
        int N = WorkingWithArrays.nextInt(); //obtain size of array from user

        //create 1D array size of N
        double[] myArray = new double[N];

        //create loop that will ask for each item in the array one by one
        for (int i = 0; i < N; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            myArray[i] = WorkingWithArrays.nextDouble();
        }

        //call mma5MethodCarson() method
        double[] result = mma5MethodCarson(myArray);

        if (result[2] != 0) { //print max, min, avg, student number if there are numbers divisible by 5
            System.out.printf("The max is %.2f\n", result[0]);
            System.out.printf("The min is %.2f\n", result[1]);
            System.out.printf("The average of the 'divisible by 5 numbers' is %.2f\n", result[2]);
            System.out.printf("My student number is %1.0f\n", result[3]);
        }

        //call footer
        myFooter(2);
        }
    }
