import java.util.Deque;
import java.util.LinkedList;

public class StringCalculator {

    public static String calculate(String expression) {
        String[] splitExpression = expression.split(" ");
        Deque<String> expressionDeque = new LinkedList<>();

        for (String element : splitExpression) {
            expressionDeque.add(element);
        }

        while (expressionDeque.size() != 1) {
            int leftNumber = Integer.parseInt(expressionDeque.pollFirst());
            String operator = expressionDeque.pollFirst();
            int rightNumber = Integer.parseInt(expressionDeque.pollFirst());

            switch (operator) {
                case "+": {
                    expressionDeque.addFirst(String.valueOf(leftNumber + rightNumber));
                    break;
                }
                case "-": {
                    expressionDeque.addFirst(String.valueOf(leftNumber - rightNumber));
                    break;
                }
                case "*": {
                    expressionDeque.addFirst(String.valueOf(leftNumber * rightNumber));
                    break;
                }
                case "/": {
                    expressionDeque.addFirst(String.valueOf(leftNumber / rightNumber));
                    break;
                }
            }
        }
        return expressionDeque.pop();
    }
}
