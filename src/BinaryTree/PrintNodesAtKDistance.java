package BinaryTree;

public class PrintNodesAtKDistance {

  static void printKNodes(Node root, int k){
    if(root == null){
      return;
    }
    if(k == 0){
      System.out.println(root.value);
      return;
    }
    printKNodes(root.left, k-1);
    printKNodes(root.right, k-1);
  }

  public static void main(String[] args) {
    Node root = Node.createBinaryTree();
    printKNodes(root, 1);
  }

}
