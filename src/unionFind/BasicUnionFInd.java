package unionFind;

import java.util.Arrays;

public class BasicUnionFInd {

    public int[] parent;
    public BasicUnionFInd(int n ) {
        parent = new int[n + 1];

        for (int i = 0; i < n+1; i++){
            parent[i] = i;
        }
    }

    public int find(int v){
        if(parent[v] != v){
            return find(parent[v]);
        }

        return v;
    }

    public boolean union(int u, int v){
        System.out.println("\n\n\tChecking if the vertices have the same parent");
        System.out.println("\t\tEdge: [" + u + ", " + v + "]");
        System.out.println("\t\tFirst vertex: " + u);
        System.out.println("\t\tSecond vertex: " + v);
        int p1 = find(u);
        int p2 = find(v);

        // If both parents are the same, a cycle exists and v1,v2 is the redundant edge
        if (p1 == p2) {
            System.out.println("\t\tSince both vertices have the same parent, this is a redundant edge");
            return false;
        }

        System.out.println("\t\tThe vertices don't have the same parent, updating parent array");

        System.out.print("\t\t\tparent: " + Arrays.toString(parent) + " ⟶ ");
        parent[p1] = p2;
        System.out.println(Arrays.toString(parent));

        return true;
    }
}
