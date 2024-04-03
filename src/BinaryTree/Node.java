package BinaryTree;

public class Node {
  int value;
  Node left;
  Node right;

  public Node(int value){
    this.value = value;
    left = null;
    right = null;
  }

  static Node createBinaryTree(){
    Node root =  new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.left.right.left = new Node(7);
    root.left.right.right = new Node(8);

    return root;
  }
}
