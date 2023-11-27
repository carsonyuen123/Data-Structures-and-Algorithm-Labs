package Q_LE2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GenericsAndArrays_Carson {
    //create header method
    public static void myHeader(int labNumber, int questionNumber, String description) {
        //print header
        System.out.println("=======================================================");
        System.out.println("Lab Exercise " + labNumber + "-Q" + questionNumber);
        System.out.println("Prepared by: Carson Yuen");
        System.out.println("Student Number: " + 251295214);
        System.out.println("Goal of this Exercise: " + description);
        System.out.println("=======================================================");
    }

    //create footer
    public static void myFooter(int labNumber, int questionNumber) {
        //print footer
        System.out.println("=======================================================");
        System.out.println("Completion of Lab Exercise " + labNumber + "-Q" + questionNumber + " is successful!");
        System.out.println("Signing off - Carson Yuen");
        System.out.println("=======================================================");
    }

        public static void main (String[]args){
            //call header
            myHeader(2, 1, "Working with arrays and generic class pairs!" );

            //create array list reference variable for years
            ArrayList<Integer> yearsList = new ArrayList(Arrays.asList(2, 3, 4, 3, 2, 2));

            //create array list reference variable for names
            ArrayList<String> namesList = new ArrayList(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));

            //create an array of Pair type reference variables
            Pair<Integer, String>[] pairArray = new Pair[yearsList.size()];

            //populate the Pair-array by key and corresponding value pair
            for (int i = 0; i < pairArray.length; i++) {
                pairArray[i] = new Pair<>(yearsList.get(i), namesList.get(i));
            }

            Scanner scanner = new Scanner(System.in); //scanner for user input
            boolean continueLoop = true; //boolean value so that the code can be repeated/ended (set as true initially)
            while (continueLoop) {

                try {
                    // Prompt the user to enter an academic year
                    System.out.print("Enter an academic year (2, 3 or 4): ");
                    int year;
                    year = scanner.nextInt();

                    if (year < 2 || year > 4) {//if years are not in between 2 and 4, ask for another input
                        System.out.println("Incorrect input! Enter Academic Year (2,3 or 4):");
                        continue;
                    }

                    //print names of leaders from the year
                    System.out.println("Found leader(s) from year " + year + ":");
                    System.out.println("Here is the list: ");
                    for (Pair<Integer, String> pair : pairArray) {
                        if (pair.getKey() == year) {
                            System.out.println(pair.getValue());
                        }
                    }

                    //ask user if they would like to continue
                    System.out.println("Do you wish to continue? (Press y to continue or any other key to terminate): ");
                    String choice = scanner.next();
                    if (choice.equals("y")) {//repeat the loop
                        continueLoop = true;
                    } else {//terminate the loop
                        continueLoop = false;
                    }

                } catch (InputMismatchException ex) {//catches exceptions that are not of type int
                    System.out.println("Incorrect input! Enter Academic Year (2,3 or 4):");
                    scanner.next();//allow user to continue input
                }

            }
            //call footer
            myFooter(2, 1);

        }
    }

