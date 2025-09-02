package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/description/
public class CombinationSum1 {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum1 obj = new CombinationSum1();
        int[] nums = {2,3,6,7};
        int target = 7;
        System.out.println(obj.combinationSum(nums, target));
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, 0, 0, new ArrayList<>(), target);
        return res;
    }

    void dfs(int[] nums, int total, int i, List<Integer> cur, int target){
        if(total == target){
            res.add(new ArrayList(cur));
            return;
        }

        if(i >= nums.length || total > target){
            return;
        }

        cur.add(nums[i]);
        dfs(nums, total + nums[i], i, cur, target);
        cur.remove(cur.size()-1);
        dfs(nums, total, i + 1, cur, target);
    }
}
