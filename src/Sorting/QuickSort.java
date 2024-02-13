package Sorting;

public class QuickSort {
    public static void main(String[] args) {

        int arr[]={20,10,24,200,39,1,5,3,88,88,-3};
        //int arr[]={100,24,200};

        quickSort(arr,0,arr.length-1);
        for(int i:arr)
        {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr,int low, int high)
    {

        if(low<high) {
            int pivot = partition(arr, low, high);


            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);

        }
    }

    private static int partition(int[] arr, int low, int high)
    {
        int i=0,j=0;
        int pivot=arr[high];
        while(j<high)
        {
            if(arr[j]<pivot)
            {
                swap(arr,i,j);
                i++;
            }

          j++;

        }
        swap(arr,i,j);
        return  i;
    }


    public static  void swap(int arr[],int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
