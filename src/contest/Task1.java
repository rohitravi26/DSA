package contest;/*
In this task you are given two strings of digits that represent (possibly very large) integers.
Your goal is to make those numbers as close to one another as possible.
In other words, you want to minimize the absolute value of their difference.
You can swap some of the corresponding digits (e.g. the first digit of the first number
with the first digit of the second number,
the second digit of the first number with the second digit of the second number, etc.).
Swapping the digits is an extremely tiring task, so you want to make as few swaps as possible.
Write a function:
class Solution & public int solution (StringS, String T); }
that, given two strings S and T, both of length N, returns the minimum number of swaps needed to minimize the difference between the two numbers represented by the input strings.
For example, given S="29162" and T="10524" your function should return 2.
We can swap the second and the fourth digits and obtain "20122" and "19564".
The difference between the numbers is 558 and the number of swaps is 2.
One can easily check that the difference is the smallest possible.
Note that we could obtain the same difference by swapping the first, third and fifth digits,
but this solution requires three swaps.
Write an efficient algorithm for the following assumptions:
• lengths of S and T are equal and within the range [1..100,000];
• S and T consist only of digits and no other characters;
• neither S nor T contain leading zeroes.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class Task1 {
    public static int solution(String S, String T) {
        // Implement your solution here
        int n = S.length();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (S.charAt(i) != T.charAt(i)) {
                pq.offer(new int[]{Math.abs(S.charAt(i) - T.charAt(i)), i});
            }
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int i = current[1];
            if (S.charAt(i) != T.charAt(i)) {
                int minDiff = Math.abs(S.charAt(i) - T.charAt(i));
                int swapIndex = -1;
                for (int j = i + 1; j < n; j++) {
                    if (S.charAt(j) != T.charAt(j)) {
                        int newDiff = Math.abs(S.charAt(j) - T.charAt(i)) + Math.abs(S.charAt(i) - T.charAt(j));
                        if (newDiff < minDiff) {
                            minDiff = newDiff;
                            swapIndex = j;
                        }
                    }
                }
                if (swapIndex != -1) {
                    char temp = S.charAt(i);
                    S = S.substring(0, i) + S.charAt(swapIndex) + S.substring(i + 1);
                    S = S.substring(0, swapIndex) + temp + S.substring(swapIndex + 1);
                    swaps++;
                }
            }
        }
        return swaps;
    }
    public static void main(String[] args) {
        System.out.println(solution("29162", "10574")); // 2
    }
}