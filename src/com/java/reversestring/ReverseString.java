package com.java.reversestring;

/**
 * Created by dasguptag on 10-12-2017.
 */
public class ReverseString {


    public static void main(String args[]){
        String input="TAVANTINPUT";
        System.out.println("INPUT String-->"+ input);
        byte[] inputBytes = input.getBytes();
        byte[] outputBytes= new byte[input.length()];

        for(int i=0; i<input.length();i++){
            outputBytes[i]= inputBytes[input.length()-i-1];

        }
        int i=1;
        int j=2;
        int sum= i+j;

        System.out.println("Reversed String-->"+ new String(outputBytes));
    }
}
