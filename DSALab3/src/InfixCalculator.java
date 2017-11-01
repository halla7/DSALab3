public class InfixCalculator {

    private MyStack stack;
    PostfixCalculator calculator = new PostfixCalculator();

    public InfixCalculator() {
        stack = new MyStack();
    }


    public String calcInfix(String input) {
        String postfix = infixToPostfix(input);
        postfix = calculator.convertToPostfix(postfix);
        return postfix;

    }
    public String infixToPostfix(String input) {
        String postfixString = "";
        for (int i = 0; i < input.length(); i++) {
            char value = input.charAt(i);
            if (value == '(') {
                stack.push('(');
            } else if (value == ')') {
                Character operator = (Character) stack.peek();
                while (!(operator.equals('(')) && !(stack.isEmpty())) {
                    postfixString += operator.charValue();
                    stack.pop();
                    operator = (Character) stack.peek();
                }
                stack.pop();
            } else if (value == '+' || value == '-') {
                // if stack is empty
                if (stack.isEmpty()) {
                    stack.push(value);
                } else {
                    Character operator = (Character) stack.peek();
                    while (!(stack.isEmpty() || operator.equals(new Character('(')) || operator.equals(new Character(')')))) {
                        stack.pop();
                        postfixString += operator.charValue();
                    }
                    stack.push(value);
                }

            } else {
                postfixString += value;
            }
        }
        while (!(stack.isEmpty())) {
            Character operator = (Character) stack.peek();
            if (!operator.equals(new Character('('))) {
                stack.pop();
                postfixString += operator.charValue();
            }
        }
        return postfixString;
    }

    private static boolean isOperator(char op) {
        if (op == '*' || op == '/' || op == '+' || op == '-') {
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean isLowerPrecedence(char op1, char op2)
    {
        switch (op1)
        {
            case '+':
            case '-':
                return !(op2 == '+' || op2 == '-');

            case '*':
            case '/':
                return op2 == '^' || op2 == '(';

            case '^':
                return op2 == '(';

            case '(':
                return true;

            default:
                return false;
        }
    }
}
