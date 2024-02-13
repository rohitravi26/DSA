package Sorting;

public class MergeSort {
    public static void main(String[] args) {

        int arr[]={20,10,24,200,39,1,5,3,88,88,-3};
        //int arr[]={100,24,200};

        mergeSort(arr,0,arr.length-1);
        for(int i:arr)
        {
            System.out.println(i);
        }

    }

    private static void mergeSort(int[] arr,int low,int high) {
        int mid;
        if(low<high) {
            mid = low + (high-low) / 2;


            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);

        }
    }

    private static void merge(int[] arr, int low,int mid, int high) {

        int n1=mid-low+1;
        int n2=high-mid;

        int left[]=new int[n1];
        int right[]=new int[n2];

        int j=0;
        for (int i=low;i<low+n1;i++)
        {
            left[j++]=arr[i];
        }
        j=0;
        for (int i=mid+1;i<=high;i++)
        {
            right[j++]=arr[i];
        }


        int i=0,k=low;
        j=0;
        while( i<n1 &&j<n2)
        {
            if(left[i]>right[j])
            {
                arr[k++]=right[j++];
            }
            else
                arr[k++]=left[i++];
        }

        while (i < n1)
        {
            arr[k++]=left[i++];
        }

        while(j < n2)
        {
            arr[k++]=right[j++];
        }


    }
}
