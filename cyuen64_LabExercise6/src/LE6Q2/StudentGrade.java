package LE6Q2;

public class StudentGrade implements Comparable<StudentGrade>{

    //declare variables
    private String firstName;
    private String lastName;
    private int grade;

    //empty constructor
    public StudentGrade(){}

    //constructor with arguments
    public StudentGrade(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    //compareTo method
    @Override
    public int compareTo(StudentGrade o) {
        int rv = 0;
        if (this.grade > o.grade){
            rv = 1;
        } else if (this.grade < o.grade){
            rv = -1;
        } else {
            rv = 0;
        }
        return rv;
    }

    //toString method
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ": " + getGrade();

    }
}
