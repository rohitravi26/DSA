package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class RearrangeArray {

  public static void main(String[] args) {
    RearrangeArray r = new RearrangeArray();
       int[] arr = {1,1,1,1,2,2,3,3};

    r.rearrangeArray(arr);
  }
  void rearrangeArray(int[] arr){
    PriorityQueue<Key> maxHeap = new PriorityQueue<>((k1, k2) -> k2.freq - k1.freq);
    Map<Integer, Long> count =
        Arrays.stream(arr).boxed()
            .collect(Collectors.groupingBy(s -> s, HashMap:: new, Collectors.counting()));

    Key prev = new Key(-1,-1);
    int n = arr.length;
    int[] result = new int[arr.length];
    int[] visited = new int[n];
    for (int val : arr) {
      if (count.get(val) > 0 && visited[val] != 1) {
        maxHeap.add(new Key(val, count.get(val).intValue()));
      }
      visited[val] = 1;
    }

    int l = 0;
    while (maxHeap.size() != 0)
    {
      // pop top element from queue and add it
      // to result
      Key k = maxHeap.poll();
//      maxHeap.poll();

      result[l] = k.key;

      // If frequency of previous element is less
      // than zero that means it is useless, we
      // need not to push it
      if (prev.freq > 0)
        maxHeap.add(prev);

      // make current element as the previous
      // decrease frequency by 'one'
      (k.freq)--;
      prev = k;
      l++;
    }

    // If length of the resultant array and original
    // array is not same then the array is not valid
    if (l != result.length)
    {
      System.out.println(" Not valid Array ");
    }
    // Otherwise Print the result array
    else
    {
      for (int i : result)
      {
        System.out.print(i + " ");
      }
    }
  }
}

class Key{
  int key;
  int freq;

  public Key(int k, int f){
    key =k;
    freq = f;
  }
}
