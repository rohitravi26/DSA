package unionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoOfIsland {

    public static void main(String[] args) {
        List<List<Character>> grid1 = Arrays.asList(
                Arrays.asList('1', '1', '1'),
                Arrays.asList('0', '1', '0'),
                Arrays.asList('1', '0', '0'),
                Arrays.asList('1', '0', '1')
        );

        // Test case 02
        List<List<Character>> grid2 = Arrays.asList(
                Arrays.asList('1', '1', '1', '1', '0'),
                Arrays.asList('1', '0', '0', '0', '1'),
                Arrays.asList('1', '0', '0', '1', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '1', '0', '1', '1')
        );

        // Test case 03
        List<List<Character>> grid3 = Arrays.asList(
                Arrays.asList('1', '1', '1', '1', '0'),
                Arrays.asList('1', '0', '0', '0', '1'),
                Arrays.asList('1', '1', '1', '1', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '1', '0', '1', '1')
        );

        // Test case 04
        List<List<Character>> grid4 = Arrays.asList(
                Arrays.asList('1', '0', '1', '0', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '0', '1', '0', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '0', '1', '0', '1')
        );

        // Test case 05
        List<List<Character>> grid5 = Arrays.asList(
                Arrays.asList('1', '0', '1'),
                Arrays.asList('0', '0', '0'),
                Arrays.asList('1', '0', '1')
        );

        List<List<List<Character>>> inputs = Arrays.asList(grid1, grid2, grid3, grid4, grid5);

        for (int i = 0; i < inputs.size(); i++) {
            System.out.println((i + 1) + ".\t Grid: ");
            printGrid(inputs.get(i));
            System.out.println("\n\t Output: " + noOfIsland(inputs.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static void printGrid(List<List<Character>> grid) {
        for (int i = 0; i < grid.size(); i++) {
            System.out.print("\t\t[");
            for (int j = 0; j < grid.get(i).size() - 1; j++) {
                System.out.print("'" + grid.get(i).get(j) + "', ");
            }
            System.out.println("'" + grid.get(i).get(grid.get(i).size() - 1) + "']");
        }
    }

    /*
     tc : o(m * n) m is the number of rows, and 𝑛 is the number of columns.
     space complexity of this solution is O(m×n), as required by the Union Find class.
     */
    public static int noOfIsland(List<List<Character>> grid){
        if (grid.isEmpty())
            return 0;

        int cols = grid.get(0).size();
        int rows = grid.size();

        UnionFind unionFind = new UnionFind(grid);

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid.get(r).get(c) == '1') {
                    // Check the horizontal and vertical neighbors of the current cell
                    // If any of the neighbors are also lands, then unite the current cell with the neighbor
                    if (r + 1 < rows && grid.get(r + 1).get(c) == '1')
                        unionFind.union(r * cols + c, (r + 1) * cols + c);
                    if (c + 1 < cols && grid.get(r).get(c + 1) == '1')
                        unionFind.union(r * cols + c, r * cols + c + 1);
                }
            }
        }
        return unionFind.count;
    }

    static class UnionFind {
        private List<Integer> parent = new ArrayList<>();
        private List<Integer> rank = new ArrayList<>();
        private int count;

        UnionFind(List<List<Character>> grid) {
            count = 0;
            int m = grid.size();
            for (int i = 0; i < m; i++) {
                int n = grid.get(0).size();
                for (int j = 0; j < n; j++) {
                    if (grid.get(i).get(j) == '1') {
                        this.parent.add(i * n + j);
                        this.count += 1;
                    } else {
                        this.parent.add(-1);
                    }
                    this.rank.add(1);
                }
            }
        }

        public List<Integer> getParent() {
            return this.parent;
        }

        // Function to return the number of connected components consisting of 1s
        public int getCount() {
            return this.count;
        }

        // Function to connect components
        public void union(int v1, int v2) {
            int p1 = find(v1);
            int p2 = find(v2);
            if (p1 != p2) {
                // The absolute value of the root node represents the size of this union
                // Make the one with larger size be the new parent
                int r1 = this.rank.get(p1);
                int r2 = this.rank.get(p2);
                if (r1 > r2) {
                    this.parent.set(p2, p1);
                } else if (r2 > r1) {
                    this.parent.set(p1, p2);
                } else {
                    this.parent.set(p2, p1);
                    this.rank.set(p1, this.rank.get(p1) + 1);
                }
                count--;
            }
        }

        public int find(int v) {
            if (this.parent.get(v) != v) {
                this.parent.set(v, find(this.parent.get(v)));
            }

            return this.parent.get(v);
        }
    }
}
