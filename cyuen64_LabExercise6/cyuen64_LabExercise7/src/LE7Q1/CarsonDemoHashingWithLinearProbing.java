package LE7Q1;

import java.util.Scanner;

public class CarsonDemoHashingWithLinearProbing {
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

    //declare variables
    public static int items;
    public static Scanner input = new Scanner(System.in);
    public static double lf;
    public static int tableCapacity;
    public static CarsonValueEntry[] hashTable;
    public static CarsonValueEntry[] workingHashTable;

    //create addValueLinearProbe method
    public static void addValueLinearProbe(Integer key) {
        int index = (key % tableCapacity + tableCapacity) % tableCapacity; //initial index based on hash function

        while (hashTable[index].getKey() != -1 && hashTable[index].getKey() != -111) {
            //linear probing: move to the next slot until an empty or available slot is found
            index = (index + 1) % tableCapacity;
        }

        //add the key to the found empty or available slot
        hashTable[index].setKey(key);
    }

    //since in hashing, the prime number has to be greater than 2, we can
    //discard 2; 0 and 1 are not prime numbers by definition
    public static int checkPrime(int n) {
        int m = n / 2;//we just need to check half of the n factors
        for (int i = 3; i <= m; i++) {
            if (n % i == 0) {//if n is not a prime number
                i = 2; //reset i to 2 so that it is incremented to 3 in the forheader
                //System.out.printf("i = %d\n",i);
                n++;//next n value
                m = n / 2;//we just need to check half of the n factors
            }
        }
        return n;
    }

    //create removeValueLinearProbe
    public static void removeValueLinearProbe(Integer key) {
        int index = (key % tableCapacity + tableCapacity) % tableCapacity; //initial index based on hash function

        while (hashTable[index].getKey() != -1) {
            //continue searching until an empty slot is found
            if (hashTable[index].getKey() == key) {
                //key is found, mark the slot as available
                hashTable[index].setKey(-111);
                System.out.println(key + " is found and removed!");
                return;
            }

            //linear probing: move to the next slot
            index = (index + 1) % tableCapacity;
        }

        //key not found message
        System.out.println("Key " + key + " not found.");
    }
    //create printHashTable method
    public static void printHashTable() {
        System.out.print("The Current Hash-Table: [");
        //return the key values that were entered
        for (int i = 0; i < tableCapacity; i++) {
            if (hashTable[i].getKey() == -1) {
                System.out.print("null");
            } else if (hashTable[i].getKey() == -111) {
                System.out.print("available");
            } else {
                System.out.print( + hashTable[i].getKey());
            }

            if (i < tableCapacity - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    //create rehashingWithLinearProbe method
    public static void rehashingWithLinearProbe() {
        //store copy of hashtable
        CarsonValueEntry[] oldHashTable = hashTable;

        //double the table capacity and find the nearest prime
        tableCapacity = checkPrime(tableCapacity * 2);

        //create a new hashtable with the updated capacity
        hashTable = new CarsonValueEntry[tableCapacity];

        //initialize the new hashtable with no argument constructor
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i] = new CarsonValueEntry();
        }

        //re-insert keys from the old hashtable into the new hashtable
        for (CarsonValueEntry entry : oldHashTable) {
            if (entry.getKey() != -1 && entry.getKey() != -111) {
                addValueLinearProbe(entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        //call header
        myHeader(7,1,"working with hashtables");

        System.out.println("Let's decide on the initial table capacity based on the load factor and dataset size");
        System.out.println("How many data items: ");
        //ask for user input for item number and load factor
        items = input.nextInt();
        System.out.println("What is the load factor (Recommended: <= 0.5): ");
        lf = input.nextDouble();

        //find the table capacity and print it
        tableCapacity = checkPrime((int) (items / lf));
        System.out.println("The minimum required table capacity would be: " + tableCapacity);

        hashTable = new CarsonValueEntry[tableCapacity];
        workingHashTable = new CarsonValueEntry[tableCapacity];

        //instantiate table contents with no argument constructor
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i] = new CarsonValueEntry();
        }

        //for each key item and add to hashtable
        for (int i = 0; i < items; i++) {
            System.out.print("Enter item " + (i + 1) + ": ");
            int key = input.nextInt();
            addValueLinearProbe(key);
        }

        //print hashtable
        printHashTable();

        System.out.println("\nLet's remove two values from the table and then add one...\n");

        //remove 2 items from hashtable
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter a value you want to remove:");
            int keyToRemove = input.nextInt();
            removeValueLinearProbe(keyToRemove);
            printHashTable();
        }

        //add a new key to the hashTable and print it
        System.out.print("Enter a value to add to the table: ");
        int newKey = input.nextInt();
        addValueLinearProbe(newKey);
        printHashTable();

        //rehashing
        System.out.println("\nRehashing the table...");
        rehashingWithLinearProbe();
        System.out.println("The rehashed table capacity is: " + tableCapacity);
        printHashTable();

        myFooter(7,1);

    }
}

