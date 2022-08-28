import java.util.*;

public class Calculator {

    private static final Set<String> OPERATOR_SET = new HashSet<>();

    static {
        OPERATOR_SET.add("+");
        OPERATOR_SET.add("-");
        OPERATOR_SET.add("*");
        OPERATOR_SET.add("/");
    }

    public int calculate(String expression) {
        Queue<String> queue = this.parseExpression(expression);
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }

        int result = 0;
        while (!queue.isEmpty()) {
            String element = queue.poll();
            if (OPERATOR_SET.contains(element)) {
                assert !queue.isEmpty();
                result = this.calculateOperator(result, element, Integer.parseInt(queue.poll()));
                continue;
            }

            result = Integer.parseInt(element);
        }

        return result;
    }

    private int calculateOperator(int operand1, String operator, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                assert false;
        }

        throw new IllegalArgumentException("Invalid expression: " +
                String.format("%s %s %s", operand1, operator, operand2));
    }

    private Queue<String> parseExpression(String expression) {
        return new LinkedList<>(Arrays.asList(expression.split(" ")));
    }
}
