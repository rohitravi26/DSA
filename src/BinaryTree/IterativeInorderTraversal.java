package BinaryTree;

import java.util.Stack;

public class IterativeInorderTraversal {
  // time : o(n) space : o(H), H = logn
  public static void inOrderTraversal(Node root) {
    Stack<Node> stack = new Stack<>();
    Node curr = root;
    while(curr != null || !stack.empty()){
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      Node item = stack.pop();
      System.out.println(item.value);
      curr = item.right;
    }
  }

  public static void main(String[] args) {
    Node root = Node.createBinaryTree();
    inOrderTraversal(root);
  }

}
