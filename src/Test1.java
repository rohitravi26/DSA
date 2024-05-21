import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {

  public static void main(String[] args) {
    int[] arr = {2,1,1,1,1,2,2,3,3};
    String input = "gainjavaknowledge";

    Map<String, Long> output = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println("Output : "+output);

    makeAdjacentDifferent(arr);
    System.out.println(arr);
    find();
  }

  private static void makeAdjacentDifferent(int[] arr) {
    Map<Integer, Long> collect =
        Arrays.stream(arr).boxed()
        .collect(Collectors.groupingBy(s -> s, HashMap:: new, Collectors.counting()));

    System.out.println(collect);

  }

  static void find(){
    List<String> pwd = new ArrayList<>();
    pwd.add("abcd");
    pwd.add("12345");
    pwd.add("abc1@");

    List<String> strings = pwd.stream().filter(s -> s.matches("[a-zA-Z]+[0-9]*[@#$]+")).collect(Collectors.toList());

    System.out.println(strings);
    givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect();
  }


  // azxxzy
  public String removeDuplicates(String s) {
    StringBuilder sb = new StringBuilder();
    sb.append(s.charAt(0));
    char prev =s.charAt(0);
    int prevIdx = 0;
    for(int i =1; i<s.length(); i++){
      if(Character.toLowerCase(s.charAt(prevIdx)) == Character.toLowerCase(s.charAt(i))){
        sb.deleteCharAt(prevIdx);
        prevIdx = prevIdx -1;
      }else {
        sb.append(s.charAt(i));
        prevIdx = i;
      }
    }
    return sb.toString();
  }public static void givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect() {
    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();

    String generatedString = random.ints(leftLimit, rightLimit + 1)
            .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

    System.out.println(generatedString);
  }


}
