package LA3Q1;

public class CarsonArray {
    private Pair<?, ?>[] testArray;

    //create constructor without parameter of size 0
    public CarsonArray() {
        this.testArray = new Pair<?, ?>[0];
    }

    //getter to return size of array
    public int getSize() {
        return testArray.length;
    }

    public Pair<?, ?> removeFromLastIndex() {
        if (testArray.length == 0) {
            return null;
        }
        Pair<?, ?> removedElement = testArray[testArray.length - 1]; //remove element from last index of array
        Pair<?, ?>[] newArray = new Pair<?, ?>[testArray.length - 1]; //new array is 1 smaller
        System.arraycopy(testArray, 0, newArray, 0, testArray.length - 1);
        testArray = newArray;//set old array to new array
        return removedElement;
    }

    public Pair<?, ?> removeFromFirstIndex() {
        if (testArray.length == 0) {
            return null;
        }
        Pair<?, ?> removedElement = testArray[0];//remove element from first index of array
        Pair<?, ?>[] newArray = new Pair<?, ?>[testArray.length - 1];//new array is 1 smaller
        System.arraycopy(testArray, 1, newArray, 0, testArray.length - 1);
        testArray = newArray;//set old array to new array
        return removedElement;
    }

    public void addAtLastIndex(Pair<?, ?> element) {
        Pair<?, ?>[] newArray = new Pair<?, ?>[testArray.length + 1]; //restructure array so that it is one larger and add element
        System.arraycopy(testArray, 0, newArray, 0, testArray.length);
        newArray[newArray.length - 1] = element;//assign value to last element in array
        testArray = newArray;//set old array to new array
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("["); //return list as a string
        for (int i = 0; i < testArray.length; i++) {
            sb.append(testArray[i].toString());
        }
        sb.append("]");
        return sb.toString();
    }
}
