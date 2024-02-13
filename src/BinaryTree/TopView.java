package BinaryTree;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

  public static void main(String[] args) {
    Node root = Node.createBinaryTree();
    findTopView(root);

    for (Entry<Integer, Integer> item : topView.entrySet()) {
      System.out.println(item.getValue());
    }
  }

  static class NodeMeta{
    int hd;
    Node node;

    public NodeMeta(int hd, Node node){
      this.hd = hd;
      this.node = node;
    }
  }

  static Map<Integer, Integer> topView = new TreeMap<>();

  static void findTopView(Node root){
    Queue<NodeMeta> queue = new ArrayDeque<>();
    queue.add(new NodeMeta(0, root));

    while(!queue.isEmpty()){
      NodeMeta nodeMeta = queue.poll();
      Node node = nodeMeta.node;
      int hd = nodeMeta.hd;
      if(!topView.containsKey(hd)){
        topView.put(hd , node.value);
      }

      if(node.left != null){
        queue.add(new NodeMeta(hd -1,node.left));
      }

      if(node.right != null){
        queue.add(new NodeMeta(hd + 1,node.right));
      }
    }
  }

}
