package com.java.defaultambiguity;

/**
 * Created by dasguptag on 10-12-2017.
 */
public class SolveDefaultAmbiguity implements InterfaceA,InterfaceB {
    @Override
    public void defaultMethod() {
        InterfaceA.super.defaultMethod();
    }
    public static void main(String args[]){
        SolveDefaultAmbiguity solveDefaultAmbiguity = new SolveDefaultAmbiguity();
        solveDefaultAmbiguity.defaultMethod();
    }


}
