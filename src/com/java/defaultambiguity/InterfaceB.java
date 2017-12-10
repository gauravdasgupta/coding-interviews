package com.java.defaultambiguity;

/**
 * Created by dasguptag on 10-12-2017.
 */
public interface InterfaceB {
    default void defaultMethod(){
        System.out.println("Hello from Interface B default method");
    }
}
