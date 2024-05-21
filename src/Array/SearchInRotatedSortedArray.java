package Array;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1};
        int item = 1;

        search(nums, item);
    }

    private static void search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(target == nums[mid]) {
                ans = mid;
                break;
            }
            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid])
                    end = mid -1;
                else
                    start = mid +1;
            } else {
                if(nums[mid+1] <= target && target <= nums[end])
                    start = mid +1;
                else {
                    end = mid -1;
                }
            }

        }

        System.out.println(ans);
    }
}
