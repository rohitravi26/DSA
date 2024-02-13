package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonPrefix {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;//Integer.parseInt(br.readLine());

        while(t-- > 0)
        {
            //int n = Integer.parseInt(br.readLine());

            String s = "geeksforgeeks geek geeks geezser"; //br.readLine();

            String[] str = s.split(" ");

            System.out.println(longestCommonPrefix(str,4));

        }

        //System.out.println(longestCommonPrefix(str,n));

    }

    private static String  longestCommonPrefix(String[] str, int n) {

        int j=0,end=0;
        boolean flag = true;
        int min=str[0].length();

        for(int i=1; i < n; i++)
        {
            if(str[i].length() < min)
                min = str[i].length();
            //System.out.println(min);
        }

        for (int i = 0; i < min ; i++)
        {
            while (j < n-1 && flag)
            {
                if(str[j].charAt(i)!=str[j+1].charAt(i))
                {
                    flag = false;
                    break;
                }
                j++;
            }

            j=0;
            if(flag)
                end++;
            else
                break;

        }
     return str[0].substring(0,end);
    }
}
