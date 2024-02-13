package Sorting;

public class InsertionSort {

    public static void main(String[] args) {

        int arr[]={20,10,24,200,39,1,5,3,88,-3};
        //int arr[]={100,24,200};

        insertionSort(arr);
        for(int i:arr)
        {
            System.out.println(i);
        }

    }

    private static void insertionSort(int[] arr) {

        int n=arr.length;
        int temp,j;
        for(int i=1;i<arr.length;++i)
        {   j=i-1;
            temp=arr[i];
            while(j>=0 && arr[j]>temp )
            {
                arr[j+1]=arr[j];
                j--;
            }

            arr[j+1]=temp;


        }



    }
}
