package BinaryTree;

import java.util.Stack;

public class IterativePreOrderTraversal {
  // time : o(n) space : o(H), H = logn
  public static void preOrderTraversal(Node root) {
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    Node curr = null;
    while(!stack.empty()){
      curr = stack.pop();
      while(curr != null) {
        System.out.println(curr.value);
        if(curr.right != null){
          stack.push(curr.right);
        }
        curr = curr.left;
      }
    }
  }

  public static void main(String[] args) {
    Node root = Node.createBinaryTree();
    preOrderTraversal(root);
  }

}
