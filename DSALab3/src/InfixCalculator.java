
public class InfixCalculator {
	
	StackList stack = new StackList();
	PostfixCalculator calculator = new PostfixCalculator();
	
	public InfixCalculator() {
		
	}
	
	
	public String calcInfix(String input) {
		String postfix = infixToPostfix(input);
		postfix = calculator.convertToPostfix(postfix);
		return postfix;
	
	}
	public String infixToPostfix(String input) {
		String output = "";
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char token = input.charAt(i);
			
			if (Character.isDigit(token)) {		// if char is an operand add it to the postfix string
				stringBuilder.append(Character.toString(token).toString());
//				stack.push(token);
//				stack.push(Character.getNumericValue(token));
			}
			if (stack.first() == null && Character.isDigit(token)) {
				stack.push(token);
			}
			
			
			else if (token == '(') {
				stack.push(token);
			}
			else if (token == ')') {
				while ((Character) stack.first() != '(') {
					stringBuilder.append(Character.toString(token).toString());
					stack.pop();
				}
			stack.pop();
			} else if (isOperator(token)) {
				while(stack.first() != null && (Character) stack.first() != '(' && isLowerPrecedence((Character) stack.first(), token)) {
					stringBuilder.append(stack.first().toString());
					stack.pop();
				}
				stack.push(token);
			}
			while(stack.first() != null) {
				stringBuilder.append(stack.first().toString());
				stack.pop();
			}
				output = stringBuilder.toString();
		}
		return output;
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
