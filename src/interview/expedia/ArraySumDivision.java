package interview.expedia;

import java.util.HashMap;
import java.util.Map;

public class ArraySumDivision {
    public static void solve(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
//        map.put(arr[0]%k,1);
        for (int i  = 0; i< n; i++){
            int key = k - (arr[i] % k == 0 ? k : arr[i] % k);
            if(map.containsKey(key)){
                map.put(key, map.get(key) - 1);
                if(map.get(key) == 0)
                    map.remove(key);
            }else {
                map.put(arr[i] %k, map.getOrDefault(arr[i] % k, 0) + 1);
            }
        }
        System.out.println(map.isEmpty());
    }
    public static void main(String[] args) {
        int[] arr = {20, 40, 120, 60, 30, 150};
        int k = 60;
        solve(arr, k);
    }
}
