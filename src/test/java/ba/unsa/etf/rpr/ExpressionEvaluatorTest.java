package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class ExpressionEvaluatorTest
{
    @Test
    void evaluateTest1() {
        String s1 = new String("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
        double a = ExpressionEvaluator.evaluate(s1);
        double e = 101;
        Assert.assertEquals(e,a);
    }

    @Test
    void evaluateTest2()
    {
        String s2 = new String("( 5 - ( ( 25 - 5 ) / ( 2 * 2 ) ) )");
        double a = ExpressionEvaluator.evaluate(s2);
        double e = 0;
        Assert.assertEquals(e,a);
    }

    @Test
    void evaluateTest3()
    {
        String s3 = new String("( ( ( ( 100 * 100 ) - ( 99 * 100 ) ) / 50 ) * sqrt ( 100 ) )");
        double a = ExpressionEvaluator.evaluate(s3);
        double e = 20;
        Assert.assertEquals(e,a);
    }

    @Test
    void evaluateTest4()
    {
        String s4 = new String("( ( ( ( ( 1 + 3 ) - 3 ) * 10 ) / 0.1 ) * sqrt ( 121 ) )");
        double a = ExpressionEvaluator.evaluate(s4);
        double e = 1100;
        Assert.assertEquals(e,a);
    }

    @Test
    void evaluateTest5()
    {
        String s5 = new String("( abc + ( 5 * 10 ) )");
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s5));
    }

    @Test
    void evaluateTest6()
    {
        String s6 = new String("1+(2+3)");
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s6));
    }
}
