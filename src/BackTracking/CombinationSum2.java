package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/description/
public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum2 obj = new CombinationSum2();
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(obj.combinationSum2(nums, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, 0, new ArrayList<>(), target);
        return res;
    }

    void dfs(int i, int[] can, int sum, List<Integer>cur, int target) {  
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;  
        }
        if(i >= can.length || sum > target)
            return;
        cur.add(can[i]);
        dfs(i+1, can, can[i] + sum, cur, target);   
        cur.remove(cur.size()-1);
        while(i+1 < can.length && can[i] == can[i+1])
            i++;
        dfs(i+1, can, sum, cur, target);    
    }
}
