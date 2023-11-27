package LE6Q1;

import com.sun.source.tree.BreakTree;

import java.util.*;

public class CarsonTestingSortingMethods {

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

    //implementation of selection sorting method
    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        long startTime = System.nanoTime(); //start timer

        //move boundary of unsorted array one  by one
        for (int i = 0; i < a.length - 1; i++) {
            //find minimum element in array
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                //compare elements in array using compareTo
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }

            //swap minimum element with first element
            T temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }

        long endTime = System.nanoTime();//stop timer
        return endTime - startTime;//return elapsed time
    }


    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        long startTime = System.nanoTime();//start timer

        //outer loop: iterates from the beginning to the second to last element
        for (int i = 1; i < a.length; i++) {
            // inner loop :iterates through the unsorted part of the array
            for (int j = 0; j < a.length - i; j++) {
                //compare adjacent elements and swap if they are in the wrong order
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();//stop timer
        return endTime - startTime;//return elapsed time
    }

    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        long startTime = System.nanoTime();//start timer

        //outer loop: iterates through the elements starting from the second element
        for (int i = 1; i < a.length; i++) {
            T key = a[i];//current element to be inserted
            int j = i - 1;//index of the element to the left of the current element

            //inner loop: shift elements greater than key to the right
            while (j > -1 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;//insert the key at its correct position
        }
        long endTime = System.nanoTime();//stop timer
        return endTime - startTime; //return elapsed time
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] S) {
        long startTime = System.nanoTime();//start timer
        mergeSort(S, Comparator.naturalOrder());//call the private helper method
        long endTime = System.nanoTime();//stop timer
        return endTime - startTime;// return elapsed time
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] S, Comparator<? super T> comp) {
        //base case: if the array is trivially sorted (contains 0 or 1 element)
        int n = S.length;
        if (n < 2) {
            return;
        }

        // divide array into halves
        int mid = n / 2;
        T[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of the first half
        T[] S2 = Arrays.copyOfRange(S, mid, n); // copy of the second half

        // conquer (with recursion)
        mergeSort(S1, comp); // sort copy of the first half
        mergeSort(S2, comp); // sort copy of the second half

        // merge sorted halves back into the original
        int i = 0, j = 0;
        while (i + j < n) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                S[i + j] = S1[i++]; // copy ith element of S1
            else
                S[i + j] = S2[j++]; // copy jth element of S2
        }

    }

    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b) {
        long startTime = System.nanoTime();//start timer

        if (a >= b) {
            long endTime = System.nanoTime();
            return endTime - startTime; //at most one element in the subrange
        }

        //choose pivot (last element in the subrange)
        T p = s[b];

        //initialize pointers
        int l = a; //left pointer
        int r = b - 1; //right pointer

        //partitioning
        while (l <= r) {
            while (l <= r && s[l].compareTo(p) <= 0) {
                l++; //find element larger than the pivot
            }
            while (l <= r && s[r].compareTo(p) >= 0) {
                r--; //find element smaller than the pivot
            }
            if (l < r) {
                //swap elements if pointers haven't crossed
                swap(s, l, r);
                l++;
                r--;
            }
        }

        //swap the pivot into its final place
        swap(s, l, b);

        //recursive calls on the partitions
        quickSort(s, a, l - 1);
        quickSort(s, l + 1, b);

        long endTime = System.nanoTime();//stop timer
        return endTime - startTime;// return elapsed time
    }
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits){
        long startTime = System.nanoTime();//start timer

        Vector<Integer>[] bucket = new Vector[10];
        //instantiate each bucket;
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //placing a[index] at end of bucket[digit]
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }
            //placing all the buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        long endTime = System.nanoTime();//end timer
        return  endTime - startTime;//return elapsed time

    }
    //The following method extracts the ith digit from a decimal number
    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }

    public static void main(String[] args) {
        //call header
        myHeader(6, 1, "using algorithms to sort arrays and testing the time");

        int sz = 50000; //integer value for size of array
        Integer[] myArray = new Integer[sz]; //create array
        Integer[] myBackupArray = new Integer[sz]; //create backup array

        for (int i = 0; i < sz; i++) {
            myArray[i] = (int) (Math.random() * 81) + 13;
        } //populate array with numbers from 13-93

        System.arraycopy(myArray, 0, myBackupArray, 0, sz);//copy array into backup array
        List<Integer> myList = Arrays.asList(myArray); //create list for array

        System.out.println("Testing execution time of different sorting methods for sorting 5 random numbers:");
        //System.out.println("The unsorted list: " + Arrays.toString(myArray));
        //sort using Collections
        long startTime = System.nanoTime(); //start timer
        Collections.sort(myList);
        long endTime = System.nanoTime(); //end timer
        long duration = (endTime - startTime);//return elapsed time
        System.out.printf("Collections' Sorting Time: %.2f milliseconds%n", duration / 1e6);
        //System.out.println("The sorted list using Collections' sort method: " + Arrays.asList(myArray) + "\n");

        System.arraycopy(myBackupArray, 0, myArray, 0, sz); // copy array

        //sort using Selections
        //System.out.println("The unsorted list: " + Arrays.toString(myArray));
        long selectionSortTime = selectionSort(myArray);
        System.out.printf("My Selection-Sort Time: %.2f milliseconds%n", selectionSortTime / 1e6);
        //System.out.println("The sorted list using selection-sort: " + Arrays.asList(myArray)+ "\n");

        System.arraycopy(myBackupArray, 0, myArray, 0, sz); //copy array

        //sort using Bubble
        //System.out.println("The unsorted list: " + Arrays.toString(myArray));
        long bubbleSortTime = bubbleSort(myArray);
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds%n", bubbleSortTime / 1e6);
        //System.out.println("The sorted list with Bubble-sort: " + Arrays.asList(myArray)+ "\n");

        System.arraycopy(myBackupArray, 0, myArray, 0, sz); //copy array

        //sort using Insertion
        //System.out.println("The unsorted list: " + Arrays.toString(myArray));
        long insertionSortTime = insertionSort(myArray);
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds%n", insertionSortTime / 1e6);
        //System.out.println("The sorted list with Insertion-sort: " + Arrays.asList(myArray)+ "\n");

        System.arraycopy(myBackupArray, 0, myArray, 0, sz); //copy array

        //sort using Merge
        //System.out.println("The unsorted list: " + Arrays.toString(myArray));
        long mergeSortTime = mergeSort(myArray);
        System.out.printf("My Merge-Sort Time: %.2f milliseconds%n", mergeSortTime / 1e6);
        //System.out.println("The sorted list with Merge-sort: " + Arrays.asList(myArray)+ "\n");

        System.arraycopy(myBackupArray, 0, myArray, 0, sz); //copy array

        //sort using QuickSort
        //System.out.println("The unsorted list: " + Arrays.toString(myArray));
        long quickSortTime = quickSort(myArray, 0 , myArray.length-1);
        System.out.printf("My Quick-Sort Time: %.2f milliseconds%n", quickSortTime / 1e6);
        //System.out.println("The sorted list with Quick sort: " + Arrays.asList(myArray)+ "\n");

        System.arraycopy(myBackupArray, 0, myArray, 0, sz); //copy array

        //sort using Bucket
        //System.out.println("The unsorted list: " + Arrays.toString(myArray));
        long bucketSortTime = bucketSort(myArray,0,myArray.length-1, 2    );
        System.out.printf("My Bucket-Sort Time: %.2f milliseconds%n", bucketSortTime / 1e6);
        //System.out.println("The sorted list with Bucket sort: " + Arrays.asList(myArray));

        //call footer
        myFooter(6, 1);

    }
}
