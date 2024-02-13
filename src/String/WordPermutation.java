package String;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WordPermutation {


    public static void main(String[] args) {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s="abc";

        printPermutation(s,"");

        System.out.println(res);
        for (String st: res)
        {
            System.out.print(st+" ");
        }
    }
    static Set<String> res = new TreeSet<>();
    private static void printPermutation(String s, String ans) {

        if(s.length()==0)
            res.add(ans);

        for (int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);

            String ros=s.substring(0,i)+s.substring(i+1);

            printPermutation(ros,ans+ch);

        }


    }
    private static void printPermutation2(String s, String ans) {

        if(s.length()==0)
            System.out.println(ans);

        boolean alpha[] = new boolean[26];

        for (int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);


                String ros=s.substring(0,i)+s.substring(i+1);
            if(!alpha[ch-'a'])
                printPermutation(ros,ans+ch);

            alpha[ch-'a']=true;

        }


    }
}
