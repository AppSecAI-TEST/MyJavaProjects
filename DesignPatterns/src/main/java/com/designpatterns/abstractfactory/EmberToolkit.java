package com.designpatterns.abstractfactory;

/**
 * Created by tharun on 10/8/17.
 */
public class EmberToolkit extends AbstractFactory {

    @Override
    public CPU createCPU() {
        System.out.println("In EmberToolkit");
        EnginolaCPU obj =  new EnginolaCPU();
        obj.status();
        return obj;
    }

    @Override
    public MMU createMMU() {
        System.out.println("In EmberToolkit");
        EnginolaMMU obj = new EnginolaMMU();
        obj.status();
        return obj;
    }
}
