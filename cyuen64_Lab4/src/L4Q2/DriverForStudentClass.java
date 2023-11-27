package L4Q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverForStudentClass {

    public static void myHeader(int labNumber, int questionNumber, String description) {
        System.out.println("=======================================================");
        System.out.println("Lab Exercise " + labNumber + "-Q" + questionNumber);
        System.out.println("Prepared by: Carson Yuen");
        System.out.println("Student Number: " + 251295214);
        System.out.println("Goal of this Exercise: " + description);
        System.out.println("=======================================================");
    }
    public static void myFooter(int labNumber, int questionNumber) {
        System.out.println("=======================================================");
        System.out.println("Completion of Lab Exercise " + labNumber + "-Q" + questionNumber + " is successful!");
        System.out.println("Signing off - Carson Yuen");
        System.out.println("=======================================================");
    }

    public static void main(String[] args) {
        //call header
        myHeader(4,2,"making array lists using Set and implementing the comparable method");

        //create an array list of type Student
        List <Student> arrayList = new ArrayList<>();

        //populate the array
        arrayList.add(new Student());
        arrayList.add(new Student("Harry", "Potter", 75.5));
        arrayList.add(new Student("Ronald", "Weasley", 86.0));
        arrayList.add(new Student("Hermione", "Granger", 91.7));
        arrayList.add(new Student("Parvati", "Patil", 93.75));

        //print out array in the default order
        System.out.println("The Score Card:");
        for (Student s : arrayList){
            System.out.println(s.toString());
        }
        System.out.println();

        //print out array in descending order
        System.out.println("The sorted list in terms of score in descending order....");
        Collections.sort(arrayList, Collections.reverseOrder());
        for (Student s : arrayList){
            System.out.println(s.toString());
        }
        System.out.println();

        //print out array sorted by last names
        System.out.println("The sorted list in terms of Last Names....");
        Collections.sort(arrayList, new HelperClassCompareLastNames());
        for (Student s : arrayList){
            System.out.println(s.toString());
        }
        System.out.println();

        //print out array sorted by first names
        System.out.println("The sorted list in terms of First Names....");
        Collections.sort(arrayList, new HelperClassCompareFirstNames());
        for (Student s : arrayList){
            System.out.println(s.toString());
        }
        System.out.println();

        //call footer
        myFooter(4,2);
    }
}
