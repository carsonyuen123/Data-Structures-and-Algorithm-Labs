package LE6Q2;

import java.util.Collections;
import java.util.Vector;

public class Carson_SortNameAndGrade {
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
        myHeader(6,2,"sorting arrays using sort method");
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny",
                "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood",
                "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26)};

        //create Vector sg
        Vector<StudentGrade> sg = new Vector<>();
        for (int i = 0; i < fnArray.length; i++) {
            sg.add(new StudentGrade(fnArray[i], lnArray[i], grd[i]));
        }

        //print out unsorted array
        System.out.println("The Unsorted Array ................");
        for (StudentGrade x: sg){
            System.out.println(x.toString());
        }

        //sort using collections
        Collections.sort(sg);

        //print out sorted array by grades in ascending order
        System.out.println("\nSorted by Grades......................");
        for (StudentGrade x: sg){
            System.out.println(x.toString());
        }

        //create an array of type LE6Q2.StudentGrade
        StudentGrade[] sgArray = new StudentGrade[fnArray.length];

        // copy sg to LE6Q2.StudentGrade array
        sg.copyInto(sgArray);

        //call sort method with key = 1 (first names)
        sort(sgArray, 1);

        //print sorted array based on first name
        System.out.println("\nSorted by First Names ............. ");
        printArray(sgArray);

        //call your sort method with key = 2 (last names)
        sort(sgArray, 2);

        //print sorted array based on last name
        System.out.println("\nSorted by Last Names...............");
        printArray(sgArray);

        myFooter(6,2);
    }

    //sort method (adjusted insertion sort)
    public static void sort(StudentGrade[] a, int key) {
        //outer loop: iterates through the elements starting from the second element
        for (int i = 1; i < a.length; i++) {
            StudentGrade current = a[i];//current element to be inserted
            int j = i - 1;//index of the element to the left of the current element

            //inner loop: shift elements greater than key to the right
            while (j > -1 && compareNames(a[j], current, key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = current;//insert the key at its correct position
        }
    }
    //compareNames method for key
    private static int compareNames(StudentGrade s1, StudentGrade s2, int key) {
        if (key == 1) {
            return s1.getFirstName().compareTo(s2.getFirstName());
        } else if (key == 2) {
            return s1.getLastName().compareTo(s2.getLastName());
        } else {
            throw new IllegalArgumentException ("invalid key");
        }
    }

    //printArray method
    private static void printArray(StudentGrade[] array){
        for (StudentGrade x: array){
            System.out.println(x);
        }

    }


}
