package BinaryTree;

// we are given inorder traversal and either preorder or postorder traversal, generate binary tree.
// we can not construct binary tree without inorder traversal
public class ConstructBinaryTree {

  static int preIndex =  0;
  static Node constructBinaryTree(int[] inOdr, int[] pre, int start, int end){
    if(start > end)
      return null;
    Node root = new Node(pre[preIndex++]);
    int idx = 0;
    for(int i = start; i <= end; i++){
      if(inOdr[i] == root.value){
        idx = i;
        break;
      }
    }

    root.left = constructBinaryTree(inOdr, pre, start, idx-1);
    root.right = constructBinaryTree(inOdr, pre, idx+1, end);

    return root;
  }
  public static void main(String[] args) {
    int[] inOrder = {40, 20, 50, 10, 30, 80, 70, 90};
    int[] preOrder = {10, 20, 40, 50, 30, 70, 80, 90};
    Node node = constructBinaryTree(inOrder, preOrder, 0, 7);
   // LevelOrderTraversal.levelOrderTraversal(node);
    IterativeInorderTraversal.inOrderTraversal(node);
  }

}
