package Concept;

public class BaseClass {
    int i =1;
    BaseClass(int i){
        this.i = i;
    }

    @Override
    public String toString() {
        return "BaseClass{" +
                "i=" + i +
                '}';
    }
}
