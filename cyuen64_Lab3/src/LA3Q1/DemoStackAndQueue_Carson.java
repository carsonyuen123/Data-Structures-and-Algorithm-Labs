package LA3Q1;

import LA3Q1.CarsonArray;
import LA3Q1.Pair;

import java.util.Scanner;

class DemoStackAndQueue_Carson{
    public static Scanner scanner = new Scanner(System.in);

    //create header
    public static void myHeader(int labNumber, int questionNumber, String description) {
        System.out.println("=======================================================");
        System.out.println("Lab Exercise " + labNumber + "-Q" + questionNumber);
        System.out.println("Prepared by: Carson Yuen");
        System.out.println("Student Number: " + 251295214);
        System.out.println("Goal of this Exercise: " + description);
        System.out.println("=======================================================");
    }

    //create footer
    public static void myFooter(int labNumber, int questionNumber) {
        System.out.println("=======================================================");
        System.out.println("Completion of Lab Exercise " + labNumber + "-Q" + questionNumber + " is successful!");
        System.out.println("Signing off - Carson Yuen");
        System.out.println("=======================================================");
    }

    public static void stackDemo(CarsonArray carsonArray) {//create stackDemo method
        System.out.println("\nYou have an empty stack: " + carsonArray.toString() + "\n");

        String choice;
        do {
            System.out.println("Stack Operation Menu:");
            System.out.println("a. Push");
            System.out.println("b. Pop");
            System.out.println("c. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();//ask user for input

            switch (choice) {//initialize cases
                case "a":
                    System.out.println("Let's push a data-item into the stack...");
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();;
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    scanner.nextLine();
                    carsonArray.addAtLastIndex(new Pair<>(year, name));//adds pair to array
                    System.out.println("The current stack: " + carsonArray.toString()+ "\n");
                    break;

                case "b":
                    System.out.println("Let's pop a data-item...");
                    Pair<?, ?> poppedItem = carsonArray.removeFromLastIndex(); //removes item from index
                    if (poppedItem != null)//pops item if stack is not null
                        System.out.println(poppedItem.toString() + " is removed! The current stack: " + carsonArray.toString() + "\n");
                    else
                        System.out.println("FYI: The stack is empty! \n");//output for when stack is null
                    break;

                case "c":
                    System.out.println("Ending Stack-demo! Goodbye! \n");
                    return;

                default:
                    System.out.println("Invalid choice!\n");//invalid choice if user inputs anything that isn't a b or c
            }
        } while (true);
    }

    public static void queueDemo(CarsonArray carsonArray) {
        System.out.println("\nYou have an empty queue: " + carsonArray.toString() + "\n");

        String choice;
        do {
            System.out.println("Queue Operation Menu:");
            System.out.println("a. Enqueue");
            System.out.println("b. Dequeue");
            System.out.println("c. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine(); //ask user for input

            switch (choice) {
                case "a":
                    System.out.println("Let's enqueue a data-item in the queue...");
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    scanner.nextLine();
                    carsonArray.addAtLastIndex(new Pair<>(year, name));//add pair to queue
                    System.out.println("The current queue: " + carsonArray.toString() + "\n");
                    break;

                case "b":
                    System.out.println("Let's dequeue a data -item...");
                    Pair<?, ?> dequeuedItem = carsonArray.removeFromFirstIndex();//removes item from queue
                    if (dequeuedItem != null)//if queue is not null, remove item
                        System.out.println(dequeuedItem.toString() + " is dequeued! The current queue: " + carsonArray.toString() + "\n");
                    else
                        System.out.println("FYI: The queue is empty! \n");//output for when queue is empty
                    break;

                case "c":
                    System.out.println("Ending Queue-demo! Goodbye! \n");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");//invalid choice if user does not enter a b or c
            }
        } while (true);
    }

    public static void main(String[] args) {
        myHeader(3, 1, "Understanding stack and queue data structures using arrays!");

        // Pair<Integer, String> testPair = new Pair<>(3, "John");
        // System.out.println("Test Pair: " + testPair.toString());

        System.out.println("\nThis code performs a demo for Stack and Queue:\n");
        CarsonArray x;
        int choice;

        do {//create main menu statements
            System.out.println("Main Demo-Menu:");
            System.out.println("1. Stack Demo");
            System.out.println("2. Queue Demo");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();//ask for user input
            scanner.nextLine(); // consume newline character so that the above switches function as intended

            switch (choice) {
                case 1:
                    x = new CarsonArray();
                    stackDemo(x);
                    break; //if case 1 is chosen, stackdemo method initializes

                case 2:
                    x = new CarsonArray();
                    queueDemo(x);
                    break;// if case 2 is chosen, queuedemo method initializes

                case 3:
                    System.out.println("Goodbye!\n");
                    myFooter(3,1); //call footer before returning
                    return;


                default:
                    System.out.println("Invalid choice");
            }
        } while (true);
    }
}