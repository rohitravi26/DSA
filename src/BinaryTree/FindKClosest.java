package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosest {
    public static void main(String[] args) {
        int[][]inputs={
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5},
                {1, 2, 4, 5, 6},
                {1, 2, 3, 4, 5, 10}
        };
        int[] k = {4, 4, 2, 3};
        int[] x = {4, 3, 10, -5};
        for(int i=0; i<k.length; i++){
            List<Integer> kList = findKClosestElement(inputs[i], k[i], x[i]);
            System.out.print(i+1);
            System.out.println(".\tThe "+k[i]+" closest elements for the number "+x[i]+ " in the array "+ Arrays.toString(inputs[i])+ " are: ");
            System.out.print("\t[");
            for(int j = 0; j < k[i]-1; j++) {
                System.out.print(kList.get(j) + ", ");
            }
            System.out.println(kList.get(k[i]-1) + "]");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static List<Integer> findKClosestElement(int[] arr, int k, int target){
        List<Integer> result = new ArrayList<>();
        int n = arr.length;

        if(k == n){
            for (int num : arr)
                result.add(num);
        }
        else if(arr[0] >= target){
            for (int i = 0; i < k; i++){
                result.add(arr[i]);
            }
        } else if(arr[n - 1] <= target){
            for (int i = n - k; i < n; i++){
                result.add(arr[i]);
            }
        }else {
            int firstClosest = findTargetPosition(arr, target);
            System.out.println(firstClosest);
            int leftClosest = firstClosest - 1;
            int rightClosest = firstClosest + 1;

            while (rightClosest - leftClosest -1 < k){
                if(arr[rightClosest] - target >= target - arr[leftClosest]){
                    leftClosest--;
                }else{
                    rightClosest++;
                }
            }

            for (int i = leftClosest+1; i < rightClosest; i++){
                result.add(arr[i]);
            }
        }

        return result;
    }

    public static int findTargetPosition(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        int mid;

        while (left <= right){
            mid = (right + left) / 2;

            if(arr[mid] == target)
                return mid;

            if(arr[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
