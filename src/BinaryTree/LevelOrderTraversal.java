package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {

  static void levelOrderTraversal(Node root){
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()){
      Node item = queue.poll();
      System.out.println(item.value);

      if(item.left != null){
        queue.add(item.left);
      }
      if(item.right != null){
        queue.add(item.right);
      }
    }
  }

  public static void main(String[] args) {
    Node root = Node.createBinaryTree();
    levelOrderTraversal(root);
  }

}
