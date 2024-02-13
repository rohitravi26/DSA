package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MostFrequentWord {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;//Integer.parseInt(br.readLine());

        while(t-- > 0)
        {
            //int n = Integer.parseInt(br.readLine());

            String s = "geeksforgeeks geeks geeks geezser"; //br.readLine();

            String[] str = s.split(" ");

            System.out.println(mostFrequentWord(str,4));

        }



    }

    private static String mostFrequentWord(String[] str, int n) {

        Map<String,Integer> wordMap = new HashMap<>();

        for (int i = 0 ; i < n ; i++)
        {
            if(wordMap.containsKey(str[i]))
            {
                wordMap.put(str[i],wordMap.get(str[i])+1);
            }

            else
                wordMap.put(str[i],1);

        }

        //Set<Map.Entry<String ,Integer>> set = wordMap.entrySet();

        int value = 0;
        String key = "";

        for (Map.Entry<String,Integer> set : wordMap.entrySet())
        {
            if(set.getValue()>= value)
            {
                key = set.getKey();
                value = set.getValue();
            }
//            else if(value==set.getValue())
//            {
//                if(set.getKey().compareTo(key)<0)
//                    key=set.getKey();
//            }

        }

        return key;
    }
}
