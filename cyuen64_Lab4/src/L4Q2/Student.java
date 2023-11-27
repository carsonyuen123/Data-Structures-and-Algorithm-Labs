package L4Q2;

public class Student implements Comparable<Student>{//implement comparable method

    //initiate variables
    private Double score;
    private String firstName;
    private String lastName;

    //create constructor without parameter
    public Student(){
        this.firstName = "Carson";
        this.lastName = "Yuen";
        this.score = 100.0;
    }

    //create constructor with parameters
    public Student (String firstName, String lastName, double score){
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    //getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getScore() {
        return score;
    }

    //create toString method
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ": " + String.format("%.2f", getScore());

    }

    //create compareTo() method that compares scores
    @Override
    public int compareTo(Student ss){
        int rv = 0;
        if (this.score > ss.score){
            rv = 1;
        } else if (this.score < ss.score){
            rv = -1;
        } else {
            rv = 0;
        }
        return rv;
    }
}
