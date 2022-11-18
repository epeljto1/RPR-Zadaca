package ba.unsa.etf.rpr;

import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input expression: ");
        String s = input.nextLine();

        try {
            System.out.println("Evalution of expression is: " + ExpressionEvaluator.evaluate(s));
        }
        catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}

