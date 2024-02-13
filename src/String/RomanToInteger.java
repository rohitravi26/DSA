package String;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    static Map<Character,Integer> romanInt = new HashMap<>();

    public static void main(String[] args) throws IOException {
        romanInt.put('I',1);
        romanInt.put('V',5);
        romanInt.put('X',10);
        romanInt.put('L',50);
        romanInt.put('C',100);
        romanInt.put('D',500);
        romanInt.put('M',1000);

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String s=br.readLine();

            convertToInteger(s.toUpperCase());


    }


}

    private static void convertToInteger(String s) {

        int n= s.length();
        int res=0;

        for(int i =0; i < n ;i++)
        {
           res=res+romanInt.get(s.charAt(i));
          if(i>0)
           if(romanInt.get(s.charAt(i))>romanInt.get(s.charAt(i-1)))
               res=res-2*romanInt.get(s.charAt(i-1));

        }

        System.out.println(res);
    }
    }
