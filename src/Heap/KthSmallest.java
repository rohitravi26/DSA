package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {

    public static void main(String[] args) {
        int[] arr = {2, 51, 3, 22, 11, 8, 43};
        int k = 3;
        findKSmallest(arr, k);
    }

    private static void findKSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        for(int i = 0; i< arr.length; i++){
            if(maxHeap.size() < k){
                maxHeap.add(arr[i]);
            }else{
                int min = maxHeap.poll();
                if(min > arr[i]) {
                    min = arr[i];
                }
                maxHeap.add(min);
            }
        }
        System.out.println(maxHeap.peek());
    }
}
