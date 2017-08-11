package com.designpatterns.abstractfactory;

/**
 * Created by tharun on 10/8/17.
 */
class EnginolaToolkit extends AbstractFactory {

    @Override
    public CPU createCPU() {
        System.out.println("In EnginolaToolkit");
        EnginolaCPU obj = new EnginolaCPU();
        obj.status();
        return obj;
    }

    @Override
    public MMU createMMU() {
        System.out.println("In EnginolaToolkit");
        EnginolaMMU obj = new EnginolaMMU();
        obj.status();
        return obj;
    }
}
