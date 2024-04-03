package DP;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MinNoOpXToY {
  static class Node {
    int n;
    int step;
    Node(int n, int step){
      this.n = n;
      this.step = step;
    }
  }

  static int getMinOperationsUsingBFS(int x, int y){
    if(y >=x)
      return y-x;
    Node node = new Node(x, 0);
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(node);
    Set<Integer> set = new HashSet<>();
    int max = x + Math.max(11 - x %11, 5 - x%5);

    while(!queue.isEmpty()){
      node = queue.poll();
      int n = node.n;
      int step = node.step;
      if(n == y) return step;
      if(set.contains(n)) continue;
      set.add(n);
      if(n % 5 == 0){
        queue.add(new Node(n/5, step +1));
      }
      if(n%11 == 0) queue.add(new Node(n/11, step+1));
      if(n-1 > y) queue.add(new Node(n-1, step +1));
      if(n +1 <= max) queue.add(new Node(n + 1, step + 1));
    }
    return -1;
  }
  public static void main(String[] args) {
    System.out.println(getMinOperationsUsingBFS(53, 1));
  }

}
