package com.java.hackerrank;
import java.util.Scanner;
/**
 * Created by dasguptag on 13-12-2017.
 */
public class sumIntArray {
    public static void main(String[] args) {

        int[] numArray; // Define an array of integers of size 4.
        numArray = new int[4];
        Scanner s = new Scanner(System.in);
        int i;
        for (i = 0; i < 4; i++) {
            numArray[i] = s.nextInt(); // Get the input
        }

        int sum = 0;
        // Write the logic to add these integers here:
        for (int j = 0; j < numArray.length; j++) {
            sum = sum + numArray[j];

        }
        System.out.print(sum); // Print the sum
        s.close();

    }
}
