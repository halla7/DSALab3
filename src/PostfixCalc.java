import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;


public class PostfixCalc {
	static final char[] operators = {'+','-','*','/'};
	StackList<Float> evalStack;
	
	PostfixCalc() {evalStack=new StackList<Float>();}
	void init() {evalStack.clear();}
	int size() {return evalStack.size();}
	
	public void init(String expr) {
		postStack.init();
		exprStatus.init();
		exprTok = new StringTokenizer(expr);
	}
	
	void update(String token) {
		if (isOperator(token)) {
			evaluate(token.charAt(0));
		}else {
			evalStack.push(Float.valueOf(token));
		}
	}
	
	float getTop() {
		Float top = evalStack.first();
		if (top == null) {
			throw new NoSuchElementException();
		}
		return top;
	}
	
	boolean isOperator(String instr) {
		if (instr.length()>1) {
			return false;
		}
		char c=instr.charAt(0);
		for (int i=0; i<operators.length; i++) {
			if (c==operators[i])
				return true;
		}
		return false;
	}
	
	void evaluate(char op) {
		Float topval = evalStack.pop();
		Float nextval = evalStack.pop();
		float tempval=0;
		switch (op) {
			case '+': tempval=nextval+topval; break;
			case '-': tempval=nextval-topval; break;
			case '*': tempval=nextval*topval; break;
			case '/': tempval=nextval/topval; break;
		}
		evalStack.push(tempval);
	}
	
	void printStack(PrintWriter pw) {
		pw.println("         ----------------->");
		pw.print("    Stack :");
		
		StackList<Float> tempStack = new StackList<Float>();
		Float obj = evalStack.first();
		while (obj != null) {
			tempStack.push(enum.nextElement());
			obj=evalStack.next();
		}
		

		obj=tempStack.first();
		while (obj != null) {
			pw.print(String.format(" | %.2f", obj));
			obj=tempStack.next();
		}
		pw.println();
		pw.println("         ----------------->");
	}
	
	public float runAll(PrintWriter pw) throws IllegalExpressionException {
		rnSome (exprTok.countTokens(), pw);
		if (postStack.size()>1) {
			throw new IllegalExpressionException ("insufficient operators");
		}
		return postStack.getTop();
		}
	}
	
}
