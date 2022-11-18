package ba.unsa.etf.rpr;

import java.util.*;

public class ExpressionEvaluator {
    public static double evaluate(String s) {

        String[] subs = s.split(" "); // Checking if input string is valid

        if (!(subs[0].equals("(")) || !(subs[subs.length-1].equals(")")))
            throw new RuntimeException("Invalid input!");

        boolean valid = true;
        for(int i = 0; i < subs.length ; i++) {
            if (subs[i].equals("(") || subs[i].equals(")") || subs[i].equals("+") || subs[i].equals("-")
                    || subs[i].equals("*") || subs[i].equals("/") || subs[i].equals("sqrt") ||
                    subs[i].matches("-?\\d+(\\.\\d+)?"))
                valid = true;
            else {
                valid = false;
                break;
            }
        }
        if (valid == false)
            throw new RuntimeException("Invalid input!");

        String[] str = s.split(" "); // Expression evaluation start
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(str));

        while (!q.isEmpty()) {
            String t = q.poll();
            switch (t) {
                case "(": break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    ops.push(t);
                    break;
                case ")":
                    vals.push(evaluateOperation(ops, vals));
                    break;
                default:
                    vals.push(Double.parseDouble(t));
                    break;
            }
        }

        return evaluateOperation(ops, vals);
    }

    private static double evaluateOperation(Stack<String>ops, Stack<Double>vals)
    {
        double v = vals.pop();

        if (!ops.empty()) {
            String o = ops.pop();
            switch (o) {
                case "+":
                    v = vals.pop() + v;
                    break;
                case "-":
                    v = vals.pop() - v;
                    break;
                case "*":
                    v = vals.pop() * v;
                    break;
                case "/":
                    v = vals.pop() / v;
                    break;
                case "sqrt":
                    v = Math.sqrt(v);
                    break;
                default: break;
            }

        }

        return v;
    }
}
