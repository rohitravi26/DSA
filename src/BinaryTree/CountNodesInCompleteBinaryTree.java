package BinaryTree;

public class CountNodesInCompleteBinaryTree {

  // tc : o(logn * logn)
  static int countNodes(Node root){
    int lh = 0, rh = 0;
    Node curr = root;
    while(curr != null){
      lh++;
      curr = curr.left;
    }
    curr = root;
    while (curr != null){
      rh++;
      curr = curr.right;
    }
    // perfect binary tree
    if(lh == rh){
      return (int) (Math.pow(2, lh) - 1);
    } else {
      return 1 + countNodes(root.left) + countNodes(root.right);
    }
  }

  public static void main(String[] args) {
    Node node = new Node(1);

    node.left = new Node(2);
    node.right = new Node(3);

    node.left.left = new Node(4);
//    node.left.right = new Node(5);

    System.out.println(countNodes(node));
  }

}
