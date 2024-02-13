package Concept;

class abc
{

    static void printMsg()
    {
        System.out.println("hello in abc class");
    }

}


public class Inheritance extends abc{

    Inheritance(int x)
    {
        super();
        int y =x;
        System.out.println("inside constructor");
    }


    public void checkvaiable()
    {
        System.out.println("hello in Inheritance class");
    }
    public static void main(String[] args) {
        Inheritance.printMsg();
    }
}
