package LA5Q;
import java.util.Scanner;
import java.util.Stack;

public class Airplane {
    //header method
    public static void myHeader(int labNumber, int questionNumber, String description) {
        System.out.println("=======================================================");
        System.out.println("Lab Exercise " + labNumber + "-Q" + questionNumber);
        System.out.println("Prepared by: Carson Yuen");
        System.out.println("Student Number: " + 251295214);
        System.out.println("Goal of this Exercise: " + description);
        System.out.println("=======================================================");
    }
    //footer method
    public static void myFooter(int labNumber, int questionNumber) {
        System.out.println("=======================================================");
        System.out.println("Completion of Lab Exercise " + labNumber + "-Q" + questionNumber + " is successful!");
        System.out.println("Signing off - Carson Yuen");
        System.out.println("=======================================================");
    }
    public static void main(String[] args) {
        //call header
        myHeader(5,1,"Creating an airplane boarding and disembarking system");

        //Using a Stack to store passenger names in "last in first out" order
        //I chose this structure assuming that people who board the plane first will be seated in the back,
        //meaning that those who are seated at the front will be closer to the exit which is assumed to be at the front of the plane
        //This obviously does not mirror real life scenarios in which there is an...
        //assigned seating based off the plane ticket and multiple exits throughout the plane
        //However, I believe this structure would take significantly longer to implement...
        //and I believe this way that I am doing it with a stack demonstrates my knowledge of...
        //linear data structures sufficiently for the required assignment
        //However, this can be seen as a limitation present in my code
        Stack<String> passengerList = new Stack<>();

        //Use of Scanner in order to receive input from user
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SE 2205 Airlines!");

        //Here I implement the use of an array
        //The main purpose of this array is so that I can use the .length feature of an array
        //which will allow me to populate my stack efficiently
        //The use of an array here is mainly for simplicity
        int[] passengerNumber = null; //define array so that it can be used outside the do while loop

        System.out.println("Enter the number of passengers:");
        //The purpose of this do while loop is to be able to catch any exceptions that...
        //may occur due to the user inputting a negative integer, double, or String value
        do {
            try{
                passengerNumber = new int[scanner.nextInt()]; //array will be length of user input
                scanner.nextLine(); //clear buffer

            }catch (Exception ex){//catch exception
                System.out.println("Enter a positive integer value");
                scanner.nextLine(); //clear buffer
            }
        }while (passengerNumber == null);


        System.out.println("Enter " + passengerNumber.length + " passenger name/s:");
        //I use a for-loop here in order to populate my stack to the length of my previously defined array
        for (int i = 0; i < passengerNumber.length; i++) {
            String passengerName = scanner.nextLine();
            passengerList.push(passengerName);
        }

        System.out.println("Here is the list of passengers:");
        System.out.println(passengerList + "\n");//display stack
        System.out.println("The passengers are now boarding the flight in the order of that their names were entered...");
        System.out.println("The plane has taken flight...");
        System.out.println("The plane has arrived at its destination safely...");
        System.out.println("Time for passengers to exit the plane... \n");

        System.out.println("Passengers at the front of the plane will exit first");

        //Here I implement the use of an iterator in order to look through my stack to see if there are...
        //any passengers on board
        while (passengerList.iterator().hasNext()) {
            System.out.println("Enter any key in order to have a passenger exit the plane");
            scanner.nextLine(); // wait for user to press Enter
            String passengerExit = passengerList.pop(); //Removes a passenger from the top of the stack
            System.out.println("Passenger " + passengerExit + " has exited the plane.");
            System.out.println("Passengers still on board: " + passengerList + "\n");//Display stack
        }

        System.out.println("All passengers have successfully exited the plane!");
        System.out.println("Thank you for flying with us today!");

        //call footer
        myFooter(5,1);

        //Closing note: One other limitation of my code may be the general readability of it since only one method is...
        //used for process of my code. But this may be negligible since it runs as expected and was easier for me to write.
    }
}
