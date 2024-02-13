package BinaryTree;

public class Diameter {

  public static void main(String[] args) {
    Node root = Node.createBinaryTree();
    getDiameterOfBinaryTree(root);
    System.out.println(ans);

  }
  static int ans = 0;
  static int getDiameterOfBinaryTree(Node root){
    if(root == null) return 0;

    int left = getDiameterOfBinaryTree(root.left);
    int right = getDiameterOfBinaryTree(root.right);
    ans = Math.max(ans, 1 + left + right);

    return 1 + Math.max(left, right);
  }
}
