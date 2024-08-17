package interview.expedia;

import java.util.*;


public class LongestIncreasingSequence {
    // recursion based
    static int find(int n, int[] nums, int prev, int curr){
        int ans = 0;
        if( curr == n)
            return 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            ans = 1 + find(n, nums, curr, curr + 1);
        }

        return Math.max(ans, find(n, nums, prev, curr + 1));
    }
    static int findUsingDp(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n + 1][n+1];

        for (int curr = n - 1; curr >=0 ; curr--){
            for(int prev = curr -1; prev >= -1; prev-- ){
                int ans = 0;
                if(prev == -1 || arr[curr] > arr[prev]){
                    ans = 1 + dp[curr + 1][curr + 1];
                }
                dp[curr][prev+1] = Math.max(ans, dp[curr + 1][prev +1]);
            }
        }

        return dp[0][0];
    }

    static int solutionOptimized(int[] arr){
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < n; i++){
            if(arr[i] > list.get(list.size() - 1)){
                list.add(arr[i]);
            }else{
                int index = getNearestSmallerIndex(list, arr[i]);
                list.set(index, arr[i]);
            }
        }
        return list.size();
    }
    static int getNearestSmallerIndex(List<Integer> list, int item){
        int size = list.size();
        return binarySearch1(list, item, 0, size -1);
    }

    static private int binarySearch(List<Integer> list, int item, int start, int end) {

        int mid = (start + end) / 2;
        int midPrior = mid -1;
        if(item == list.get(mid))
            return mid - 1;
        if(item < list.get(mid)){
            if(mid == 0)
                return -1;
            if(item > list.get(midPrior))
                return midPrior;
            return binarySearch(list, item, start, mid -1);
        }else{
           return binarySearch(list, item, mid +1, end);
        }
    }

    static private int binarySearch1(List<Integer> list, int item, int start, int end) {
       int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midVal = list.get(mid);
            if(midVal == item)
                return mid;
            if(midVal < item)
                start = mid + 1;
            else {
                ans = mid;
                end = mid -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,10,4,3,8,9};

        System.out.println(find(arr.length, arr, -1, 0));
        //System.out.println(findUsingDp(arr));
        System.out.println(solutionOptimized(arr));
        System.out.println(binarySearch1(Arrays.asList(new Integer[] {1, 4, 6}), 5, 0, 2 ));
    }
}
