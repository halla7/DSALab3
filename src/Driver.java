
public class Driver {
	static String mString="89*75*+8/";  // 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ
	static int mVal1, mVal2, mTotal;
	
	public static void main(String[] args){
		
		StackList<Character> myCharStack = new StackList("CharacterStack");
		StackList<Integer> myIntStack = new StackList("IntegerStack");
		for (int i=0; i<mString.length(); ++i){
			if (mString.charAt(i)=='('){
				System.out.println("You need to push :"+mString.charAt(i));
			}else if (mString.charAt(i)==')'){
				System.out.println("You need to pop :"+mString.charAt(i));
			}else if (Character.isDigit(mString.charAt(i))){
//				System.out.println("You need to store this :"+mString.charAt(i));
				myCharStack.push(mString.charAt(i));
			}else {
				System.out.println("This must be an operand to take action on :"+mString.charAt(i));
				if (myCharStack.size()>1) {
					mVal2=getValue(myCharStack.pop());
					mVal1=getValue(myCharStack.pop());
				}else if (myCharStack.size()==1) {
					mVal2=getValue(myCharStack.pop());
					mVal1=myIntStack.pop();
				}else {
					mVal2=myIntStack.pop();
					mVal1=myIntStack.pop();
				}
				if (mString.charAt(i)=='+') {
					mTotal=mVal1+mVal2;
					System.out.println(mVal1+" + "+mVal2+" = "+mTotal);
				}else if (mString.charAt(i)=='-') {
					mTotal=mVal1-mVal2;
					System.out.println(mVal1+" - "+mVal2+" = "+mTotal);	
				}else if (mString.charAt(i)=='*') {
					mTotal=mVal1*mVal2;
					System.out.println(mVal1+" * "+mVal2+" = "+mTotal);	
				}else if (mString.charAt(i)=='/') {
					mTotal=mVal1/mVal2;
					System.out.println(mVal1+" / "+mVal2+" = "+mTotal);	
				}
				myIntStack.push(mTotal);
			}
		}
		System.out.println("Character Stack item count is now   :"+myCharStack.size());
		System.out.println("Last item pushed to stack           :"+myCharStack.first());
//		System.out.println("Second to Last item pushed to stack :"+myList.next());
//		for (int j=myCharStack.size(); j>0; j--) {
//			System.out.println("Last item poped from stack          :"+myCharStack.pop());
//		}
		System.out.println("Integer Stack item count is now     :"+myIntStack.size());
		System.out.println("Last item pushed to stack           :"+myIntStack.first());
//		for (int j=myIntStack.size(); j>0; j--) {
//			System.out.println("Last item poped from stack          :"+myIntStack.pop());
//		}
//		System.out.println("Last item in stack now              :"+myList.first());
//		System.out.println("Next to last item in stack now      :"+myList.next());
//		System.out.println("When using get the last item in stack is :"+myList.get(myList.size()));
	}
	
	static int getValue(char digit) {
		switch (digit)
        {
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            case '0': return 0;
        } // end switch

        return 0;
		
	}
}
