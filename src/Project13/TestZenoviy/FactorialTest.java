package Project13.TestZenoviy;

import Project13.Zenoviy.Factorial;

import Project13.Zenoviy.LimitException;
import Project13.Zenoviy.NegativeIntegerException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Zenovii on 13.04.2016.
 */
public class FactorialTest {

    private static Factorial factorial;

    @BeforeClass
    public static void setUp() {
        factorial = new Factorial();
    }

    @Test
    public void testFactorialPositive(){
        final String a = "5";
        final  double result = factorial.getFactorial(a);

       Assert.assertEquals(120,result,0);
    }

    @Test(expected = LimitException.class)
    public void testMaxLimitNumber() throws Exception {
        final String a="175";
        factorial.checkInteger(a);
    }

    @Test(expected = NegativeIntegerException.class)
    public void testNegativeNumber() throws Exception {
        final String a = "-1";
        factorial.checkInteger(a);
    }

    @Test(expected = NumberFormatException.class)
    public void testStringNumberFormat() throws Exception {
       final String a="s";
        factorial.checkInteger(a);
    }

    @Test(expected = NumberFormatException.class)
    public void testDoubleNumberFormat() throws Exception {
        final String a="5.5";
        factorial.checkInteger(a);

    }
}