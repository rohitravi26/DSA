package String;

import java.util.*;
import java.lang.*;
import java.io.*;

public class LongestDistinctChar {
    public static void main(String[] args) throws IOException {
        //code

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        while (t-- > 0) {
//            String s = br.readLine();
        String s="abababcdefababcdab";
        longestDistinctChar(s.toLowerCase().toCharArray());
       // System.out.println(s.toCharArray().t);


        //}
    }

    public static void longestDistinctChar(char[] str) {
        int n = str.length;

        int start = 0, end = 0;
        int alphabets[] = new int[26];
        Arrays.fill(alphabets, -1);
        int max=1;
        String s="";
        for (int i = 0; i < n; i++) {

            if (alphabets[str[i] - 'a'] == -1) {
                alphabets[str[i] - 'a'] = i;
                end++;
            } else {
                // for the character found after the start window,
                // then we need to simply increment the end because there is no matching character after the start window
                if (alphabets[str[i] - 'a'] < start) {
                    alphabets[str[i] - 'a'] = i;
                    end++;
                }
                // for the matching character after the start window
                else {
                    start = alphabets[str[i] - 'a'] + 1;
                    alphabets[str[i] - 'a'] = i;
                    end++;
                }


            }
        if(max<end-start)
        {
           s=String.valueOf(str).substring(start,end);
        }
        max=Integer.max(max,end-start);
        }
        System.out.println(max+ " "+ s);
    }

}