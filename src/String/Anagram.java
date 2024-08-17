package String;

import java.util.HashMap;
import java.util.Map;

public class Anagram
{

    // Function to check whether two strings are anagram of
// each other
    // this will not work for the case: str1: aa, str2 : bb
    static boolean areAnagram(String str1, String str2)
    {
        // If two strings have different length
        if (str1.length() != str2.length())
        {
            return false;
        }

        // To store the xor value
        int value = 0;

        for (int i = 0; i < str1.length(); i++)
        {
            value = value ^ (int) str1.charAt(i);
            System.out.println(value+" "+(int) str1.charAt(i));
            value = value ^ (int) str2.charAt(i);
            System.out.println(value+" "+(int) str2.charAt(i));
        }

        return value == 0;

    }

    static boolean areAnagrams(String str1, String str2) {
        // If two strings have different length
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : str1.toCharArray()){
            map.put(ch, 1 + map.getOrDefault(ch, 0));
        }

        for(char ch : str2.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }else{
                int val = map.get(ch);
                if(val == 1)
                    map.remove(ch);
                else
                    map.put(ch, val - 1);
            }
        }

        return map.isEmpty();
    }

    // Driver code
    public static void main(String[] args)
    {
        String str1 = "geeksforgeeks";
        String str2 = "forgeeksgeeks";
        if (areAnagrams(str1, str2))
            System.out.println("The two strings are anagram of each other");
        else
            System.out.println("The two strings are not anagram of each other");

    }
}


