package L4Q1;

public class MyStudent {

    //declare variables
    private String firstName;
    private Double score;

    //create no argument constructor
    public MyStudent(){
        this.firstName = "Carson";
        this.score = 89.55;
    }

    //create constructor with argument
    public MyStudent(String firstName, Double score){
        this.firstName = firstName;
        this.score = score;
    }

    //create toString method that returns first name and score
    public String toString(){
        return firstName + ": " + String.format("%.2f", score);
    }
}
