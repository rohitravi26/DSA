package Array;

public class MedianSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 22};
        int[] arr2 = {3, 6, 9, 14, 17};

        findMedian(arr1, arr2);
    }

    private static void findMedian(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        if(n > m){
            findMedian(arr2, arr1);
        }


    }

}
