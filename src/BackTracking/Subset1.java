package BackTracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/description/
public class Subset1 {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Subset1 obj = new Subset1();
        int[] nums = {1,2,3};
        obj.subsetUsingBit(nums, nums.length);
    }

    void dfs(int[] nums, List<Integer> cur, int i){
        if(i>=nums.length)
            return;

        cur.add(nums[i]);

        res.add(new ArrayList<>(cur));

        dfs(nums, cur, i + 1);

        cur.remove(cur.size()-1);

        dfs(nums, cur, i+1);
    }

    void subsetUsingBit(int[] nums, int n){
        for(int i =0; i<(1<<n) ; i++){
            List<Integer> subset = new ArrayList<>();
            for(int j=0; j<n ; j++){
                if((i & (1<<j)) != 0){
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }
        System.out.println(res);
    }
}
