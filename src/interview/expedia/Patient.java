package interview.expedia;

import java.util.Comparator;

public class Patient implements Comparable<Patient> {
    String name;
    int age;

    String gender;

    /*
    senior citizen(age>55) > female(10-18) > male(10-18) > female(age>18)> Male(age>18)
     */
    @Override
    public int compareTo(Patient p) {
        int age1 = this.age;
        int age2 = p.age;

        String gender1 = this.gender;


        return 0;
    }

    int getPriority(){
        if(this.age > 55)
            return 0;
        return 1;
    }
}
