package interview.expedia;

import java.util.Arrays;

import static Sorting.QuickSort.swap;

public class SortArray {

    public static void sort(int[] arr){
        int n = arr.length;
        int l = 0;
        int h = n-1;
        for (int i = 0; i<n && i < h;){
            if(arr[i] == 0){
                swap(arr, i, l);
                i++;
                l++;
            }
            else if(arr[i] == 2){
                swap(arr, i, h);
                h--;
            } else
                i++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 2, 1, 0, 2, 0, 1, 1, 2, 2, 0, 1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }
}
