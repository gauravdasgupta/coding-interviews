package com.java.findoddnumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dasguptag on 21-12-2017.
 */
public class FindOddNumbers {
    /*
     *getOddNumbers(intl,int r) takes 2 numbers l and r and returns all odd numbers between l and r (including them if they are odd)
     */
    static int[] getOddNumbers(int l, int r){
        List<Integer> oddNumbers = new ArrayList<>();
        int count=0;
        for(int i=l;i<=r;i++){
            if((i%2)!=0){
                oddNumbers.add(i);
                count++;
            }
        }
        int oddOutput[]= new int[oddNumbers.size()];
        int ctr=0;
        for(int oddNumber:oddNumbers){
            oddOutput[ctr]=oddNumber;
            ctr++;
        }
        return oddOutput;
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int output[]=getOddNumbers(l,r);
        System.out.println(Arrays.toString(output));
    }
}
