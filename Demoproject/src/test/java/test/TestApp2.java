package test;

/**
 * Created by tharun on 28/6/17.
 */
import junit.framework.Assert;
import org.junit.Test;
import com.aoperations.Multiply;

public class TestApp2 {

    @Test
    public void multiplyCheck() {
        Multiply obj = new Multiply();
        obj.setA(10);
        obj.setB(5);
        Assert.assertEquals(obj.getMulAns(), 50);

    }

}

