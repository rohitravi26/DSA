import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Test {
    static class Key {
      int key;
      int val;
      Key(int k, int v){
       key = k;
       val =v;
      }
    }
    public static void main(String[] args) {

      PriorityQueue<Key> maxHeap = new PriorityQueue<>((k1, k2) -> k2.val - k1.val);
      int[] arr = {2,1,1,1,1,2,2,3,3};
      Map<Integer, Long> collect =
          Arrays.stream(arr).boxed()
              .collect(Collectors.groupingBy(s -> s, HashMap:: new, Collectors.counting()));



        int z = 2;

        z/=z--;
        int a = -123;
        int x = a% 10;
        System.out.println(x);
    }
}
