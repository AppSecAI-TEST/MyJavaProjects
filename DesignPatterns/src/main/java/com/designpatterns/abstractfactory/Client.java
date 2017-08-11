package com.designpatterns.abstractfactory;

/**
 * Created by tharun on 10/8/17.
 */
public class Client {
    public static void main(String[] args) {
        //type: Architecture.EMBER or Architecture.ENGINOLA
        Architecture value = Architecture.ENGINOLA;
        AbstractFactory factory = AbstractFactory.getFactory(value);
        CPU cpu = factory.createCPU();
        value = Architecture.EMBER;
        AbstractFactory factory2 = AbstractFactory.getFactory(value);
        MMU mmu = factory2.createMMU();
    }
}
