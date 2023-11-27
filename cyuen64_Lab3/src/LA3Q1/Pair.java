package LA3Q1;

public class Pair <Y extends Number, N>{
    private Y key;
    private N value;

    //create constructor with parameters
    public Pair(Y key, N value){
        this.key = key;
        this.value= value;
    }

    //create constructor without parameters
    public Pair(){
    }

    //define setters
    public void setKey(Y key){
        this.key = key;
    }

    public void setValue(N value) {
        this.value = value;
    }

    //define getters
    public Y getKey(){
        return key;
    }

    public N getValue(){
        return value;
    }

    @Override
    public String toString() {//toString method to return string containing Y and N
        return "[YR: " + key + ", NM: " + value +"]";
    }
}
