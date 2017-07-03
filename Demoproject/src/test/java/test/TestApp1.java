package test;

/**
 * Created by tharun on 28/6/17.
 */
import junit.framework.Assert;
import org.junit.Test;
import com.aoperations.Multiply;

public class TestApp1 {

    @Test
    public void multiplyCheck() {
        Multiply obj = new Multiply();
        obj.setA(10);
        obj.setB(5);
        //expected:50, actual:56
        Assert.assertEquals(obj.getMulAns(), 56);

    }

}

