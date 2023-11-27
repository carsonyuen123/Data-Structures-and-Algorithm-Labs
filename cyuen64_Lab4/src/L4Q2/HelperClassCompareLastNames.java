package L4Q2;

import java.util.Comparator;

public class HelperClassCompareLastNames implements Comparator<Student> {//implement comparator method
    public int compare(Student s1, Student s2){//compare last names using compare() method
        return s1.getLastName().compareTo(s2.getLastName());
    }
}
