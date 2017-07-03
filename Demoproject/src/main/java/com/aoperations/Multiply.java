package com.aoperations;

import java.util.Scanner;

/**
 * Created by tharun on 28/6/17.
 */
public class Multiply {
    private int a, b;
    public int getMulAns(){
        return a * b;
    }
    public void setA(int v){
        a = v;
    }
    public void setB(int v){
        b = v;
    }
    public void getValues(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1st number");
        a =sc.nextInt();
        sc=new Scanner(System.in);
        System.out.println("Enter 2nd number");
        b =sc.nextInt();
    }
}
