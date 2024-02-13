package Sorting;

public class BubbleSort {

    public static void main(String[] args) {

        int arr[]={20,10,24,200,39,1,5,3,88,-3};
        //int arr[]={100,24,200};

        bubblesort(arr);
        for(int i:arr)
        {
            System.out.println(i);
        }

    }

    private static void bubblesort(int[] arr) {
        int n=arr.length;
        int temp;
        boolean flag;
        for(int i=0;i<n;i++)
        { flag=true;
            for(int j=0;j<n-i-1;j++)
            {

                if(arr[j]>arr[j+1])
                {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=false;
                   // System.out.println("hello flag checking");
                }
                if(flag)
                    break;
            }
        }
    }
}
