package BinaryTree;

public class BurnTree {

  static class Depth{
    int depth;

    public Depth(int d){
      this.depth = d;
    }
  }

  public static void main(String[] args) {
    Node root = Node.createBinaryTree();
    System.out.println(getMinTime(root, 4));
  }

  public static int getMinTime(Node node, int target){
    Depth d = new Depth(-1);
    burn(node, d, target);
    return ans;
  }

  static int ans = -1;
  private static int burn(Node root, Depth depth, int target) {
    if(root == null) return 0;

    if(root.value == target){
      depth.depth = 1;
      return 1;
    }

    Depth ld = new Depth(-1);
    Depth rd = new Depth(-1);

    int lh = burn(root.left, ld, target);
    int rh = burn(root.right, rd, target);

    if(ld.depth != -1){
      depth.depth = 1 + ld.depth;
      ans = Math.max(ans, 1 + ld.depth + rh);
    }else if(rd.depth != -1){
      depth.depth = 1 + rd.depth;
      ans = Math.max(ans, 1 + rd.depth + lh);
    }
    return Math.max(lh, rh) + 1;
  }

}
