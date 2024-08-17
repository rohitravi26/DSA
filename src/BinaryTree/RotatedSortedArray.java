package BinaryTree;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArray {
    public static void main(String[] args) {
        List<List<Integer>> numList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(10, 20, 30, 40, 50, 60),
                Arrays.asList(12, 24, 35, 47, 58, 69, 72, 83, 94),
                Arrays.asList(5, 13, 28, 41, 56, 63, 77, 82, 99, 105),
                Arrays.asList(5, 7, 12, 17, 21, 28, 33, 37, 41, 48, 52, 57, 62, 68, 72)
        );

        List<Integer> targetList = Arrays.asList(1, 50, 12, 56, 5);

        for (int i = 0; i < targetList.size(); i++) {
            System.out.println((i + 1) + ".\tSorted array: " + numList.get(i) +
                    "\n\ttarget " + targetList.get(i) +
                    " found at index " + binarySearch(numList.get(i), targetList.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static int binarySearch(List<Integer> list, Integer target) {
        int start = 0, end = list.size() - 1;
        int mid;

        while (start <= end){
            mid = (start + end) / 2 ;
            if(list.get(mid) == target)
                return mid;
            if(list.get(end) > list.get(mid + 1)){
                if(target >= list.get(mid + 1) && target <= list.get(end)){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }else {
                if(target >= list.get(start) && target <= list.get(mid - 1)){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}
