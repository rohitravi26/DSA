package BinaryTree;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

  public static void main(String[] args) {
    Node root = Node.createBinaryTree();
    findBottomView(root);

    for (Entry<Integer, Integer> item : bottomView.entrySet()) {
      System.out.println(item.getValue());
    }
  }

  static class NodeMeta{
    int hd;
    Node node;

    public NodeMeta(int hd, Node node){
      this.hd = hd;
      this.node = node;
    }
  }
  /*
  use hashmap to reduce time complexity from nlogn to n, use variable min and max
  for (; min <= max; min++) {
     System.out.print(map.get(min) + " ");
  }
 */

  static Map<Integer, Integer> bottomView = new TreeMap<>();

  static void findBottomView(Node root){
    Queue<Pair<Integer, Node>> queue = new ArrayDeque<>();
    queue.add(new Pair<>(0, root));

    while(!queue.isEmpty()){
      Pair<Integer, Node> pair = queue.poll();

      int hd = pair.getKey();
      Node node = pair.getValue();
      bottomView.put(hd , node.value);
      if(node.left != null){
        // min = Math.min(min, curr.hd - 1);
        queue.add(new Pair<>(hd -1,node.left));
      }

      if(node.right != null){
        // max = Math.max(max, curr.hd + 1);
        queue.add(new Pair<>(hd + 1,node.right));
      }
    }
  }

}
