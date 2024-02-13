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
    root.left.right = new Node(4);

    root.right = new Node(3);

    root.right.left = new Node(5);

    return root;
  }
}
