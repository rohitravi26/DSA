package BinaryTree;

// tc: o(n)
public class CheckForBalancedTree {
  static int isBalancedTreeUtil(Node root){
    if(root == null){
      return 0;
    }
    if(root.left == null && root.right == null){
      return 1;
    }

    int lh = isBalancedTreeUtil(root.left);
    if(lh == -1)
      return -1;

    int rh = isBalancedTreeUtil(root.right);
    if(rh == -1)
      return -1;

    if(Math.abs(lh-rh) > 1){
      return -1;
    }else {
      return 1 + Math.max(lh, rh);
    }
  }

  static void isBalancedTree(Node root){
    int res = isBalancedTreeUtil(root);
    if(res == -1){
      System.out.println("Not a balanced tree");
    }
    System.out.println("Is a balanced tree");
  }

  public static void main(String[] args) {
    Node node = Node.createBinaryTree();
    isBalancedTree(node);
  }

}
