package unionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[][] inputNums = {
                {150, 14, 200, 1, 3, 2},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 3, 5, 7},
                {7, 6, 5, 4, 3, 2, 1},
                {7, 6, 5, 1}
        };

        for (int i = 0; i < inputNums.length; i++) {
            System.out.println((i + 1) + ".\tnums = " + Arrays.toString(inputNums[i]));
            System.out.println("\tThe length of the longest consecutive sequence is: " + longestConsecutiveSequence(inputNums[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static int longestConsecutiveSequence(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        UnionFind unionFind = new UnionFind(nums);
        Map<Integer, Integer> parent = unionFind.parent;

        for (int num : nums) {
            if (parent.containsKey(num + 1)) {
                unionFind.union(num, num + 1);
            }
        }
        return unionFind.maxLength;
    }

    static class UnionFind {
        public Map<Integer, Integer> parent;
        public Map<Integer, Integer> size;
        public int maxLength;

        public UnionFind(int[] arr) {
            parent = new HashMap<>();
            size = new HashMap<>();
            maxLength = 1;

            for (int j : arr) {
                parent.put(j, j);
                size.put(j, 1);
            }
        }

        public int find(int num) {
            if (parent.get(num) != num)
                parent.put(num, find(parent.get(num)));

            return parent.get(num);
        }

        public void union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) {
                return;
            }

            int r1 = size.get(p1);
            int r2 = size.get(p2);

            if (r1 < r2) {
                int swap = p1;
                p1 = p2;
                p2 = swap;
            }
            size.put(p1, size.get(p1) + size.get(p2));
            parent.put(p2, p1);
            maxLength = Math.max(maxLength, size.get(p1));
        }
    }

}
