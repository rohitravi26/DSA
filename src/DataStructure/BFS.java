package DataStructure;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    int v;
    LinkedList<Integer>[] nodes;

    public BFS(int v) {
        this.v = v;
        nodes = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            nodes[i] = new LinkedList<>();
        }

    }

    void addEdge(int v, int w) {
        nodes[v].add(w);

    }

    void BFSUtil(int v, boolean[] visited) {
        visited[v] = true;

        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(v);

        while (queue.size() != 0) {
            int n = queue.poll();
            //visited[n] = true;
            System.out.println(n+ " ");
            Iterator<Integer> listIterator = nodes[n].listIterator();

            while (listIterator.hasNext()) {
                int n1 = listIterator.next();
                if(!visited[n1]) {
                    queue.add(n1);
                    visited[n1] = true;
                }
            }

        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS(4);
        bfs.addEdge(0,1);
        bfs.addEdge(0,2);
        bfs.addEdge(1,2);
        bfs.addEdge(2,0);
        bfs.addEdge(2,3);
        bfs.addEdge(3,3);

        boolean[] visited = new boolean[4];

        bfs.BFSUtil(2,visited);
    }
}
