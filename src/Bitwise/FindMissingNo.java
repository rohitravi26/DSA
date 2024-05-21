package Bitwise;

public class FindMissingNo {
    public static void main(String[] args) {
        int[] arr = {1,2,4,2,5};
        findMissing(arr);
    }

    private static void findMissing(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int actualSum = n *(n+1)/2;
        int product= 1;
        int actualProduct = 1;
        int j = 1;
        for(int i : arr){
            sum += i;
            product *= i;
            actualProduct *= j++;
        }

        int x = actualProduct > product ? actualProduct / product : product/actualProduct;
        int y = Math.abs(actualSum - sum);


    }
}
