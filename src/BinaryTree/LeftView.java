package BinaryTree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LeftView {
  public static void main(String[] args) {
    Node root = Node.createBinaryTree();
    findLeftView(root, 0);

    for (Entry<Integer, Integer> item : leftView.entrySet()) {
      System.out.println(item.getValue());
    }
  }

  static Map<Integer, Integer> leftView = new LinkedHashMap<>();

  static void findLeftView(Node root, int level){
    if(root == null) return;
    // remove this to get right view.
    if(!leftView.containsKey(level)){
      leftView.put(level , root.value);
    }

    findLeftView(root.left, level +1);
    findLeftView(root.right, level +1);
  }
}
