package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.assertTrue;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class ExpressionEvaluatorTest
{
    @Test
    public void evaluateTest1() {
        String s1 = new String("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
        double a = ExpressionEvaluator.evaluate(s1);
        double e = 101;
        Assert.assertEquals(e,a);
    }

    @Test
    public void evaluateTest2()
    {
        String s2 = new String("( 5 - ( ( 25 - 5 ) / ( 2 * 2 ) ) )");
        double a = ExpressionEvaluator.evaluate(s2);
        double e = 0;
        Assert.assertEquals(e,a);
    }

    @Test
    public void evaluateTest3()
    {
        String s3 = new String("( ( ( ( 100 * 100 ) - ( 99 * 100 ) ) / 50 ) * sqrt ( 100 ) )");
        double a = ExpressionEvaluator.evaluate(s3);
        double e = 20;
        Assert.assertEquals(e,a);
    }
}
