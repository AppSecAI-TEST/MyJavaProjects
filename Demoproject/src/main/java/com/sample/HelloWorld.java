package com.sample;

import com.aoperations.Multiply;

/**
 * Created by tharun on 27/6/17.
 */
public class HelloWorld {
    public static void main(String [] args){
        callMultiply();
    }
    public static void callLogging(){
        System.out.println("Hello Logging!!");
        LoggingDemo obj = new LoggingDemo();
        obj.createLog();
    }
    public static void callMultiply(){
        System.out.println("Hello Multiply!!");
        Multiply obj = new Multiply();
        obj.getValues();
        System.out.println(obj.getMulAns());
    }
}
