package BinaryTree;

import java.util.Stack;

public class SpiralTraversal {

  static void traverse(Node root){
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();

    stack1.push(root);

    while (!stack1.empty()){
      Node node = stack1.pop();
      System.out.println(node.value);
      Node right = node.right;
      Node left = node.left;
      if(left != null){
        stack2.push(left);
      }
      if(right != null){
        stack2.push(right);
      }
      if (!stack1.empty()) continue;
      while (!stack2.empty()){
        Node parent = stack2.pop();
        System.out.println(parent.value);
        Node lch = parent.left;
        Node rch = parent.right;

        if(rch != null) stack1.push(rch);
        if(lch != null) stack1.push(lch);
      }
    }
  }

  public static void main(String[] args) {
    Node root = Node.createBinaryTree();

    traverse(root);
  }
}
