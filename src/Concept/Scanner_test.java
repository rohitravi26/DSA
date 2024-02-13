package Concept;

import java.util.Scanner;

public class Scanner_test {


    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        int mi = scan.nextInt();
        double md = scan.nextDouble();
             String ms = s.trim();
        //   while(scan.hasNext())
        //      ms = ms+" "+ scan.next();

         ms = scan.nextLine();
        /* Declare second integer, double, and String variables. */

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

        /* Print the sum of both integer variables on a new line. */

        int sum = i + mi;
        System.out.println(sum);
        /* Print the sum of the double variables on a new line. */
        System.out.println(d + md);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */

        System.out.println(ms);
        scan.close();

    }

}