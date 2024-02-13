import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
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
  }

  private static void makeAdjacentDifferent(int[] arr) {
    Map<Integer, Long> collect =
        Arrays.stream(arr).boxed()
        .collect(Collectors.groupingBy(s -> s, HashMap:: new, Collectors.counting()));

    System.out.println(collect);

  }
}
