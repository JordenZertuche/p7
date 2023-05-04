package edu.guilford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ListImplementation {
    public static void main(String[] args) {

        final int MAX = 50000;
        ArrayList<String> arrayVersion = new ArrayList<String>();
        LinkedList<String> linkedVersion = new LinkedList<String>();

        // Add randomly generated strings to each list
        for (int i = 0; i < MAX; i++) {
            StringBuilder sb = new StringBuilder();

            // generate random letters from a-z using the ACII codes
            for (int j = 0; j < 10; j++) {
                sb.append((char) ((int) (Math.random() * 26) + 97));
            }
            arrayVersion.add(sb.toString());
            linkedVersion.add(sb.toString());
        }
        // System.out.println(arrayVersion);
        // time 1,000,000 random gets from the arraylist implementation
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int index = (int) (Math.random() * MAX);
            String s = arrayVersion.get(index);
        }
        long endTime = System.nanoTime();
        System.out.println("Time to get 1,000,000 random elements from an ArrayList: "
                + String.format("%.2f", (endTime - startTime) / 1.e6) + " milliseconds");

        // time 1,000,000 random gets from the linked list implementation
        startTime = System.nanoTime();
        for (int i = 0; i < 1e6; i++) {
            int index = (int) (Math.random() * MAX);
            String s = linkedVersion.get(index);
            
        }
        endTime = System.nanoTime();
        System.out.println("Time to get 1,000,000 random elements from a LinkedList: "
                + String.format("%.2f", (endTime - startTime) / 1.e6) + " milliseconds");

        // time sorting the arraylist implementation
        startTime = System.nanoTime();
        Collections.sort(arrayVersion); // use the available sort method (which is a mergesort)
        endTime = System.nanoTime();
        System.out.println("Time to sort an ArrayList: "
                + String.format("%.2f", (endTime - startTime) / 1.e6) + " milliseconds");

        // time sorting the linked list implementation
        startTime = System.nanoTime();
        Collections.sort(linkedVersion); // use the available sort method (which is a mergesort)
        endTime = System.nanoTime();
        System.out.println("Time to sort a LinkedList: "
                + String.format("%.2f", (endTime - startTime) / 1.e6) + " milliseconds");

        // create a shuffled list of 1000 integers
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < MAX; i++) {
            intList.add(i);
        }
        Collections.shuffle(intList);

        //create a merged sort method that uses the arraylist implementation and linkedlist implementation
        startTime = System.nanoTime();
        mergeSort(intList);
        endTime = System.nanoTime();
        System.out.println("Time to sort an ArrayList and LinkedList using merge sort: "
                + String.format("%.2f", (endTime - startTime) / 1.e6) + " milliseconds");

                //create a loop that can get each element from the arraylist and linkedlist sequentially
        startTime = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            intList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("Time to get each element from an ArrayList sequentially: "
                + String.format("%.2f", (endTime - startTime) / 1.e6) + " milliseconds");

                

    }

    private static void mergeSort(ArrayList<Integer> intList) {
    }

}