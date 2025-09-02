package stack;

import java.util.Arrays;
import java.util.Stack;

//316. Remove Duplicate Letters
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {

        char[] arr = s.toCharArray();
        int[] count = new int[26];
        for (char c : arr) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Arrays.stream(count).max().getAsInt();
        boolean[] visited = new boolean[26];

        for(char ch : arr){
            int index = ch - 'a';
            count[index]--;
            if(visited[index]) continue;
            visited[index] = true;
            while(!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0){
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
        }
        

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
        
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters obj = new RemoveDuplicateLetters();
        String s = "cdadabcc";
        System.out.println(obj.removeDuplicateLetters(s));
    }
    
}
614127134599891712, 615189298710424064