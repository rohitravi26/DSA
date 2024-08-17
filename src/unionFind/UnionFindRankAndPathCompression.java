package unionFind;

public class UnionFindRankAndPathCompression {
    public int[] parent;
    public int[] rank;

    public UnionFindRankAndPathCompression(int n ){
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i<n+1; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int v){
        if(parent[v] != v)
            return parent[v] = find(parent[v]);

        return v;
    }

    public boolean union(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);

        if(p1 == p2){
            return false;
        }

        int r1 = rank[v1];
        int r2 = rank[v2];

        if(rank[p1] > rank[p2]){
            rank[p1] += rank[p2];
            parent[p2] = p1;
        }else {
            rank[p2] += rank[p1];
            parent[p1] = p2;
        }
        return true;
    }
}
