package DataStructure;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    int v;
    LinkedList<Integer> nodes[] ;
    public DFS(int v) {
        this.v = v;
        nodes = new LinkedList[v];
        for (int i = 0; i < v; i++)
        {
            nodes[i] = new LinkedList<>();
        }

    }

    void addEdge(int v, int w){
        nodes[v].add(w);

    }

    void DFSUtil(int v, boolean[] visited){

        visited[v] = true;
        System.out.println(v+ " ");

        Iterator<Integer> listIterator = nodes[v].listIterator();

        while (listIterator.hasNext()){
                int n = listIterator.next();
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }

    void DFStraversal(int v){
        boolean visited[] = new boolean[this.v];

        DFSUtil(v,visited);
    }

    public static void main(String[] args) {

        DFS dfs = new DFS(4);
        dfs.addEdge(0,1);
        dfs.addEdge(0,2);
        dfs.addEdge(1,2);
        dfs.addEdge(2,0);
        dfs.addEdge(2,3);
        dfs.addEdge(3,3);

        boolean visited[] = new boolean[4];

        dfs.DFSUtil(2,visited);
    }
}
