package Sorting;

public class HeapSort {
    public static void main(String[] args) {
        int arr[]={20,10,24,200,39,1,5,3,88,88,-3};
        //int arr[]={100,24,200};


    heapSort(arr);
        for(int i:arr)
    {
        System.out.println(i);
    }

    }

    private static void heapSort(int[] arr) {

        int n=arr.length;

        for (int i=n/2-1;i>=0;i--)
        {
            heapify(arr,n,i);
        }
        int temp;
        for (int i=n-1;i>=0;i--)
        {
           temp=arr[0];
           arr[0]=arr[i];
           arr[i]=temp;
           heapify(arr,i,0);
        }


    }

    private static void heapify(int[] arr, int n, int i) {

        int largest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && arr[largest]< arr[left])
            largest=left;

        if(right<n && arr[largest] < arr[right])
            largest=right;

        if(largest!=i)
        {
            int swap=arr[largest];
            arr[largest]=arr[i];
            arr[i]=swap;

            heapify(arr,n,largest);
        }


    }

}
