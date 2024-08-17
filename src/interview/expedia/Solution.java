package interview.expedia;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

      String inputString = "Java Concept Of The Day Day";

      Map<String, Long> countMap = Arrays.stream(inputString.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

      System.out.println(countMap);

      String input = "abcda";

      System.out.println(findDuplicates(input));

    }

    private static int findDuplicates(String input) {

        Set<Character> characters = new HashSet<>();
        for (int i = 0 ; i < input.length(); i++){
            if(characters.contains(input.charAt(i))){
                return i;
            }else {
                characters.add(input.charAt(i));
            }
        }

        return  -1;

    }
}
