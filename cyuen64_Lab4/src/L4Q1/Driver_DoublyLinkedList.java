package L4Q1;

public class Driver_DoublyLinkedList {
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
        myHeader(4,1,"implementing a doubly linked list");

        //create a doubly linked list
        DoublyLinkedList<MyStudent> CarsonList = new DoublyLinkedList<>();

        //create MyStudent reference variables
        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.35);
        MyStudent s2 = new MyStudent("Luna", 87.5);
        MyStudent s3 = new MyStudent("Vincent", 60.5);
        MyStudent s4 = new MyStudent("Hermione", 89.2);

        //add first 4 items to list
        System.out.println("Adding 4 students to the list.");
        CarsonList.addLast(s0);
        CarsonList.addLast(s1);
        CarsonList.addLast(s2);
        CarsonList.addLast(s3);

        //print out first 4 items of list
        System.out.println("The list Content:");
        System.out.println(CarsonList.toString());

        //find the location of node s2 and s3 in list
        DoublyLinkedList.Node<MyStudent> nodeS2 = CarsonList.findNode(s2);
        DoublyLinkedList.Node<MyStudent> nodeS3 = CarsonList.findNode(s3);

        //add s4 in between s2 and s3
        System.out.println("Adding Hermione to the list in between Luna and Vincent...");
        CarsonList.addBetween(s4, nodeS2, nodeS3);

        //print out entire list
        System.out.println("The list Content:");
        System.out.println(CarsonList.toString());

        //call footer
        myFooter(4,1);
    }

}
