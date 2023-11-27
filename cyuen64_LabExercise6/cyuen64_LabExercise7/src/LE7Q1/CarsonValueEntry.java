package LE7Q1;

public class CarsonValueEntry {

    //declare variable
    private Integer key;

    //create no argument constructor that returns -1
    public CarsonValueEntry(){
        this.key = -1;
    }

    //create constructor with argument
    public CarsonValueEntry(Integer key){
        this.key = key;
    }

    //create setters and getters
    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }
}
