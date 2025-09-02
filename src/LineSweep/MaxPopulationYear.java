package LineSweep;

import java.util.Map;
import java.util.TreeMap;

public class MaxPopulationYear {

    public int maximumPopulation(int[][] logs) {
        //Arrays.sort(logs,(a,b) -> a[0]-b[0]);

        int year = 0 ;
        int max = 0;
        Map<Integer, Integer> map = new TreeMap<>();

        for(int[] log : logs ){
            map.put(log[0], map.getOrDefault(log[0], 0)+1);
            map.put(log[1], map.getOrDefault(log[1], 0)-1);

        }

        int prev=0;
        int curr=0;
        for(int key : map.keySet()){
            curr = prev + map.get(key);
            if(curr > max){
                year = key;
                max = curr;
            }
            prev = curr;
        }
        return year;
    } 
}