package String;

/*
    Write a function that takes a string as input
    and checks whether it can be a valid palindrome by removing at most one character from it.
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        return isPalindromeUtil(s, 0, s.length() - 1, 0);
    }

    static boolean isPalindromeUtil(String s, int i, int j, int mismatchCount){
        if(mismatchCount > 1)
            return false;

        while( i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                if(isPalindromeUtil(s, i+1, j, mismatchCount + 1)){
                    return true;
                }
                return isPalindromeUtil(s, i, j-1, mismatchCount + 1);
            }
        }

        return true;
    }
}