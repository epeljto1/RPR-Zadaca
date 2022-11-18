package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.assertTrue;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class ExpressionEvaluatorTest
{
    @Test
    public void evaluateTest1() {
        String s1 = new String ("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )") ;
        double a = ExpressionEvaluator.evaluate(s1);
        double e = 101;
        Assert.assertEquals(e,a);
    }
}
