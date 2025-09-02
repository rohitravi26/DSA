package BinaryTree;

public class Sqrt {

    static float sqroot(int n, float p) {
        float l = 0, r = n;
        while(Math.abs(l-r) > p){
            float mid = l + (r - l)/2;
            if(mid * mid < n){ 
             l  = mid;
            } else{
                r = mid;
            }
        }
        return (r+l)/2;
    }
    public static void main(String[] args) {
        int n = 50;
        System.out.println(sqroot(n, 0.001f));
    }
}