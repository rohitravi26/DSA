package test;


import BinaryTree.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {


        /*
        Find minimum distance between words  String sentence = "cat is a beautiful category of animal . but white and gold color cat are pretty animal";
source = cat
destination = animal
         */

        String sentence = "cat is a beautiful category of animal . but white and gold color cat are cat pretty animal";

        System.out.println(findMinimumDistanceBetweenWords(sentence, "cat", "animal"));
    }

    private static int findMinimumDistanceBetweenWords(String sentence, String src, String dest){
        String[] words = sentence.split(" ");

        int min = Integer.MAX_VALUE;
        int srcIdx = -1;
        boolean isSrcFound = false;


        for(int i = 0; i< words.length; i++){
            if(words[i].equals(src)){
                srcIdx = i;
                isSrcFound = true;
            }

            if(words[i].equals(dest) && isSrcFound){
                min = Math.min(i - srcIdx -1 , min);
                isSrcFound = false;
            }
        }

       return min;
    }

    /*
    Program questions:
1) Get the count of each letter
"A_1",
"A_2"
"B_1",
"A_a3",
"C_2",
"B_2",
"A_",

output: [A,3] [B,2], [c,1]
     */

    static void findCountOfLetters(){
        List<String> letters = new ArrayList<>();
        letters.add("A_1");
        letters.add("A_2");
        letters.add("A_");
        letters.add("B_1");
        letters.add("B_2");

//        letters.stream().filter(item -> item.lastIndexOf('_') != item.length() - 1).map(item -> item.split("_")[0]).collect()
    }


    /*

    filter : remove all nulls, employee having id
    list of emp, sorting name,  des,salary
     */


    class Employee {
        Integer id;
        String name;
        String designation;
        double salary;
    }

    List<Employee> getEmployees(List<Employee> employees){
        List<Employee> sortedEmployees = employees.stream().filter(employee -> employee.id != null)
                .sorted(Comparator.comparing(employee -> employee.name))
                .sorted(Comparator.comparing(employee -> employee.designation))
                .collect(Collectors.toList());
        return sortedEmployees;

    }




}
// usage of multiple db
// microservice communication
// lambda
// java8
// multithreading