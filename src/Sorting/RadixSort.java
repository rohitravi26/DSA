package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RadixSort {


    public static void main(String[] args) {

        // this implementation is for only positive number
        //System.out.println(-1%10);
        int arr[]={20,10,24,200,39,1,5,3,88,88-3};

        int max=getMax(arr);
        for(int exp=1;max/exp>0;exp*=10)
        {
            countSort(arr,arr.length,exp);
        }

        for(int i:arr)
        {
            System.out.println(i);
        }

    }

    private static void countSort(int[] arr, int n, int exp) {

        int output[] = new int[n];
        int count[] = new int[10];

        Arrays.fill(count,0);
        for(int i=0;i<n;i++)
        {
            count[(arr[i]/exp)%10]++;
        }

        for(int i=1;i<n;i++)
            count[i] += count[i-1];

        for(int i=n-1;i>=0;i--)
        {
            output[count[(arr[i]/exp)%10]-1]=arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for (int i=0;i < n;i++)
            arr[i]=output[i];
    }

    public static int getMax(int arr[])
    {
      int max=arr[0];

      for(int i=0;i<arr.length;i++)
      {
          if(arr[i]> max)
              max=arr[i];
      }
      return max;
    }

}
