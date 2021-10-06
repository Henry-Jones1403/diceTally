package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("How many sides are there to your dice>");
        int sides = input.nextInt();
        System.out.println("How many times would you like to throw the dice?");
        int repeats = input.nextInt();
        HashMap<Integer, Integer> thrown = new HashMap<Integer, Integer>();
        for (int i = 0; i < sides + 1; i++) {
            thrown.put(i, 0);
        }
        for (int i = 0; i < repeats; i++) {
            int randomNumber = (random.nextInt((sides))) + 1;
            thrown.put(randomNumber, thrown.get(randomNumber) + 1);
        }
        PrintWriter file = new PrintWriter("storageFile", "UTF-8");
        ArrayList<String> myArray = new ArrayList<String>();
        for (int i = 0; i < sides; i++) {
            double percentage = (((double) (thrown.get(i + 1)) / (double) (repeats)) * 100);
            System.out.println("you rolled a " + (i + 1) + " " + thrown.get(i + 1) + " times!!! This made up " + String.format("%.2f", percentage) + "% of the rolls");
            myArray.add(String.format("%.2f", percentage) + "% ---> you rolled " + (i + 1) + " " + thrown.get(i + 1) + " times ");
            //file.println(i + 1 + "--->   " + thrown.get(i + 1) + " times    --->    " + percentage + "%");
        }Collections.sort(myArray);

        for (int i = sides; i > 0 ; i--) {
            file.println(myArray.get(i-1));

        }
        file.close();

//make a 3d array, 1st variable in each sub array is the percentage which gets sorted then the second is the writing which is printed with it.


    }
}
