package LE7Q2;
import LE7Q1.*;
import static LE7Q1.CarsonDemoHashingWithLinearProbing.*;

public class CarsonDemoHashingWithAllOpenAddressingTechniques {

    public static void addValueQuadraticProbe(Integer key) {
        int index = (key % tableCapacity + tableCapacity) % tableCapacity; // Initial index based on hash function
        int i = 1;

        while (hashTable[index].getKey() != -1 && hashTable[index].getKey() != -111) {
            // Quadratic probing: Move to the next slot using quadratic function
            index = (index + i * i) % tableCapacity;
            i++;

        }

        // Add the key to the found empty or available slot
        hashTable[index].setKey(key);
    }

    public static void addValueDoubleHashing(Integer key) {
        int index = (key % tableCapacity + tableCapacity) % tableCapacity;
        int q = thePrimeNumberForSecondHashFunction(tableCapacity);
        int i = 1;

        while (hashTable[index].getKey() != -1 && hashTable[index].getKey() != -111) {
            // Double hashing: Move to the next slot using a second hash function
            index = (index + i * q) % tableCapacity;
            i++;
        }

        // Add the key to the found empty or available slot
        hashTable[index].setKey(key);
    }

    public static int thePrimeNumberForSecondHashFunction(int capacity) {
        int q = checkPrime(capacity - 1); // The second prime should be immediately smaller than the table capacity
        return q;
    }

    public static void emptyHashTable() {
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i].setKey(-1);
        }
    }

    public static void printArray(Integer[] array) {
        for (Integer item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Call your header method if applicable
        System.out.println("Let's demonstrate our understanding on all the open addressing techniques...");


        // Prompt the user for the number of items and load factor
        System.out.println("How many data items: ");
        items = input.nextInt();
        System.out.println("What is the load factor (Recommended: <= 0.5):");
        lf = input.nextDouble();

        // Find the table capacity and print it
        tableCapacity = checkPrime((int) (items / lf));
        System.out.println("The minimum required table capacity would be: " + tableCapacity);

        // Create a QuaziValueEntry type array and instantiate the table contents
        hashTable = new CarsonValueEntry[tableCapacity];

        //instantiate table contents with no argument constructor
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i] = new CarsonValueEntry();
        }

        // Create an Integer array with values
        Integer[] valuesArray = {7, 14, -21, -28, 35};

        // Print the Integer array
        System.out.print("The given dataset is: ");
        printArray(valuesArray);

        // Add each key item from the Integer array to the hashTable using linear probing
        System.out.println("\nAdding data - linear probing resolves collision");
        for (int i = 0; i < items; i++) {
            addValueLinearProbe(valuesArray[i]);
        }

        // Print the hash table after linear probing
        printHashTable();

        // Reset the hashTable
        emptyHashTable();

        // Add each key item from the Integer array to the hashTable using quadratic probing
        for (int i = 0; i < items; i++) {
            addValueQuadraticProbe(valuesArray[i]);
        }

        // Print the hash table after quadratic probing
        System.out.println("\nAdding data - quadratic probing resolves collision");
        printHashTable();

        // Reset the hashTable
        emptyHashTable();

        // Add each key item from the Integer array to the hashTable using double hashing


        // Print the hash table after double hashing
        System.out.println("\nAdding data - double-hashing resolves collision");
        for (int i = 0; i < items; i++) {
            addValueDoubleHashing(valuesArray[i]);
        }
        System.out.println("The q value for double hashing is: " + thePrimeNumberForSecondHashFunction(tableCapacity));
        printHashTable();

        // Call your footer method if applicable
    }

}
