package FastSlowPointers;

public class HappyNumber {

    static boolean isHappyNo(int n){
        int slowP = n;
        int fastp = sumOfSquareOfDigits(n);

        while(true){
            if(slowP == 1 || fastp == 1)
                return true;
            if(slowP == fastp)
                return false;
            slowP = sumOfSquareOfDigits(slowP);
            fastp = sumOfSquareOfDigits(sumOfSquareOfDigits(fastp));
        }
    }

    static int sumOfSquareOfDigits(int n){
        int sum = 0;
        while(n > 0){
            int remainder = n % 10;
            sum += remainder * remainder;

            n = n/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        int a = -7;
        int b = 8;

        System.out.println(a % b );
        System.out.println(isHappyNo(23));
    }
}
