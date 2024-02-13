package String;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class StringPermutation {
    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0)
        {
            String s=br.readLine();
            res=new TreeSet<String>();
            printPermutation(s,"");
            for (String st: res)
            {
                System.out.print(st+" ");
            }

            t--;
            System.out.println("");
        }


        //code
    }

    static Set<String> res;
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
}