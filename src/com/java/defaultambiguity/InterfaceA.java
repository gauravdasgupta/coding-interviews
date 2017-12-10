package com.java.defaultambiguity;

/**
 * Created by dasguptag on 10-12-2017.
 */
public interface InterfaceA {
    default void defaultMethod(){
        System.out.println("Hello from Interface A default method");
    }
}
