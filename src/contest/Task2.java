package contest;

import java.util.Stack;

public class Task2 {
    /*
    A word machine is a system that performs a sequence of simple operations on a stack of integers. Initially the stack is empty. The sequence of operations is given as a string.
    Operations are separated by single spaces. The following operations may be specified:
    • an integer X (from 0 to 220 - 1): the machine pushes X onto the stack;
    • "POP": the machine removes the topmost number from the stack;
    • "DUP": the machine pushes a duplicate of the topmost number onto the stack;
    • "+": the machine pops the two topmost elements from the stack, adds them together and pushes the sum onto the stack;
    • "-": the machine pops the two topmost elements from the stack, subtracts the second one from the first (topmost) one and pushes the difference onto the stack.
    After processing all the operations, the machine returns the topmost value from the stack.
    The machine processes 20-bit unsigned integers (numbers from 0 to 220 - 1). An overflow in addition or underflow in subtraction causes an error. The machine also reports an error when it tries to perform an operation that expects more numbers on the stack than the stack actually contains. Also, if, after performing all the operations, the stack is empty, the machine reports an error.
    For example, given a string "4 5 6 - 7 +", the machine performs the following operations:
    operation | comment | stack --
    - | I [empty] "4" | push 4 | | | 4 "5" | push 5 | 1
    14, 5 "6" | push 6 | 1 | 4, 5, 6 "-" | subtract 5 from 6 | | 1
    4, 1 "7" | push 7 | | | 4, 1, 7"+" | add 1 and 7 | | | 4, 8
    Finally, the machine will return 8.
    Given a string "13 DUP 4 POP 5 DUP + DUP + -", the machine performs the following operations:
    operation | comment | stack --
    | 1 lempty] "13" | push 13 | | | 13 "DUP" |
    duplicate 13 | | | 13, 13 "4" | push 4 | | | 13, 13, 4 "POp" | pop 4 | | |13, 13 "5" | push 5 | | | 13, 13, 5 "DUP" | duplicate 5 | | | 13, 13, 5, 5 "+" | add 5 and 5 | | | 13, 13, 10 "DUP" | duplicate 10 | | | 13, 13, 10, 10 "+" | add 10 and 10
    1 1 / 13, 13, 20 "-" | subtract 13 from 20 | | | 13, 7
    Finally, the machine will return 7.
    Given a string "5 6 + -", the machine reports an error. After the addition, there is only one number on the stack and the subtraction operation expects two.
    Given a string "3 DUP 5 - -", the machine reports an error. The second subtraction yields a negative result.
    Write a function:
    int solution (char *S);
    that, given a string S containing a sequence of operations for the word machine, returns the result the machine would return after processing the operations. The function should return -1 if the machine would report an error while processing the operations.
    Examples:
    1. Given S = "4 5 6 - 7 +", the function should return 8, as explained above.
    2. Given S = "13 DUP 4 POP 5 DUP + DUP + -" the function should return 7.
    3. Given S = "5 6 + -", the function should return - 1.
    4. Given S = "3 DUP 5 - -", the function should return -1.
    5. Given S = "1048575 DUP +", the function should return -1.
    Assume that:
    • the length of string S is within the range [0..2,000];
    • S is a valid sequence of word machine operations.
     */
    public static int solution(String S) {
        String[] operations = S.split(" ");
        Stack<Integer> stack = new Stack<>();
        int MAX_VALUE = (1 << 20) - 1;
        int MIN_VALUE = 0;
        int output = -1;

        try {
            for (String op : operations) {
                switch (op) {
                    case "POP":
                        stack.pop();
                        break;
                    case "DUP":
                        stack.push(stack.peek());
                        break;
                    case "+":
                        stack.push(Math.addExact(stack.pop(), stack.pop()));
                        break;
                    case "-":
                        stack.push(Math.subtractExact(stack.pop(), stack.pop()));
                        break;
                    default:
                        stack.push(Integer.parseInt(op));
                        break;
                }
            }
            output = stack.isEmpty() ? -1 : stack.peek();
        } catch (Exception e) {
            return -1;
        }
        if(output > MAX_VALUE || output < MIN_VALUE) {
            return -1;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(solution("4 5 6 - 7 +")); // 8
        System.out.println(solution("13 DUP 4 POP 5 DUP + DUP + -")); // 7
        System.out.println(solution("5 6 + -")); // -1
        System.out.println(solution("3 DUP 5 - -")); // -1
        System.out.println(solution("1048575 DUP +")); // -1
    }
}
