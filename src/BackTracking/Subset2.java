package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Subset2 obj = new Subset2();
        int[] nums = {1,2,2};
        System.out.println(obj.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    void dfs(int[] nums, List<Integer> cur, int i){
        if(i==nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(nums, cur, i+1);
        cur.remove(cur.size()-1);

        while(i+1<nums.length && nums[i] == nums[i+1])
            i++;

        dfs(nums, cur, i+1);
    }
}
