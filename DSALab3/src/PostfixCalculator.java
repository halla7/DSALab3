public class PostfixCalculator {

//    StackList stack = new StackList();
    MyStack stack = new MyStack();
    public PostfixCalculator() {

    }

    /*
     * Operators are +, -, *, /, and ^.
     * 3 levels of precedence
     * 3 -
     * 2- *, /
     */
    public String convertToPostfix(String input) {
        input = input.replaceAll("\\s+","");
        String postfix = null;
        int value1 = 0;
        int value2 = 0;
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            if (token == '*') {
                value2 = (int) stack.pop();
                value1 = (int) stack.pop();
                result = value1 * value2;
                stack.push(result);
            }
            if (token == '/') {
                value2 = (int) stack.pop();
                value1 = (int) stack.pop();
                result = value1 / value2;
                stack.push(result);
            }
            if (token == '+') {
                value2 = (int) stack.pop();
                value1 = (int) stack.pop();
                result = value1 + value2;
                stack.push(result);
            }
            if (token == '-') {
                value2 = (int) stack.pop();
                value1 = (int) stack.pop();
                result = value1 - value2;
                stack.push(result);
            }
            if(Character.isDigit(token)) {
                stack.push(Character.getNumericValue(token));
            }

        }
        String endResult = stack.pop().toString();

        return endResult;

    }


}
