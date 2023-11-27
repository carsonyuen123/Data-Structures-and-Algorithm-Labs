package L4Q2;

import java.util.Comparator;

public class HelperClassCompareFirstNames implements Comparator<Student> {//implement comparator method
    public int compare(Student s1,Student s2){//compare first names using compare() method
        return s1.getFirstName().compareTo(s2.getFirstName());
    }
}
