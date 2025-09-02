package BinaryTree;

public class MinimizeDistance {

    public static void main(String[] args) {
        MinimizeDistance obj = new MinimizeDistance();
        int[] stations = {1,2,3,4,5,6,7,8,9,10};
        int K = 9;
        System.out.println(obj.minMaxDist(stations, K));
    }
    public double minMaxDist(int[] stations, int K) {
        // code here
        
        double left = 0, right = getMaxDistance(stations); // or give last array element value
        double mid = 0.00d;
        
        while(right - left > 1e-6){
            mid = (right + left)/2;
            
            if(checkDistance(stations, mid, K)){
                right = mid;
            }else {
                left = mid;
            }
        }
        
        return mid;
    }
    
    boolean checkDistance(int[] nums, double minDis, int k){
        int total = 0 ;
        for(int i = 0; i < nums.length - 1; i++){
            total += (int)(nums[i+1] - nums[i])/minDis;
            if(total > k){
                return false;
            }
        }
        
        return true;
    }
    
    int getMaxDistance(int[] stations){
        int max = 0;
        
        for(int i : stations){
            if(max < i)
                max = i;
        }
        return max;
    }
}

