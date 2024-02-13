package Sorting;

public class SelectionSort {

    public static void main(String[] args) {

        int arr[]={20,10,24,200,39,1,5,3,88,-3};
        //int arr[]={100,24,200};

        selectionSort(arr);
        for(int i:arr)
        {
            System.out.println(i);
        }

    }

    private static void selectionSort(int[] arr) {
        int n=arr.length;

        int min;

        for (int i=0;i<n;i++)
        {
            min=arr[i];
            for(int j=i+1;j<n;j++)
            {
                if(arr[i]>arr[j])
                {
                    arr[i]=arr[j];
                    arr[j]=min;
                    min=arr[i];
                }

            }
        }

    }
}
