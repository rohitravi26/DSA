package BinaryTree;

public class ChildrenSumProperty {
  static boolean isCSum(Node root){
    if(root == null){
      return true;
    }
    if(root.left == null && root.right == null){
      return true;
    }

    int sum = root.value;
    if(root.left != null){
      sum = sum - root.left.value;
    }
    if(root.right != null){
      sum = sum - root.right.value;
    }

    return sum == 0 && isCSum(root.left) && isCSum(root.right);
  }
  public static void main(String[] args) {

  }

}
