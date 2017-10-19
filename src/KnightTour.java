
public class KnightTour {
	private int steps=0, squares=8;
	private StackList<String> moves;
	
	
	public static void main(String[] args) {
		listSquares(8);
		System.out.println("\nFollowing are Squares or Cells you can get to from D4...");
		getMoves("D4",8);
	}
	
	public KnightTour(){
		// TODO Auto-generated constructor stub
		
	}
	
	public KnightTour(int numsquares) {
		squares=numsquares;
	}
	
	public static void listSquares(int num) {
		String square1="A1", newSquare="A1";
		int mod=0;
		for (int i=0; i<num*num; i++) {
			mod=i%num;
			if (mod==0){
					if (i==0)
						newSquare=Character.toString(square1.charAt(0));
					else {
						newSquare=Character.toString((char) (square1.charAt(0)+1));
					}
					newSquare+=Character.toString('1');
			}else {
					newSquare=Character.toString(square1.charAt(0));
					newSquare+=(char) (square1.charAt(1)+1);
			}
			System.out.println(newSquare);
			square1=newSquare;
			newSquare="";
//			System.out.println("mod value :"+i%num);
		}
		
	}
	
	static void getMoves(String fromCell, int squares) {
		char col, row;
		int colMax='A', rowMax='1';
		String newSquare;
		
		switch (squares)
		{
        	case 1: colMax='A'; rowMax='1';break;
        	case 2: colMax='B'; rowMax='2';break;
        	case 3: colMax='C'; rowMax='3';break;
        	case 4: colMax='D'; rowMax='4';break;
        	case 5: colMax='E'; rowMax='5';break;
        	case 6: colMax='F'; rowMax='6';break;
        	case 7: colMax='G'; rowMax='7';break;
        	case 8: colMax='H'; rowMax='8';break;
        	case 9: colMax='I'; rowMax='9';break;
        	case 10: colMax='J'; rowMax='0';break;
        	case 11: colMax='K'; rowMax='A';break;
        	case 12: colMax='L'; rowMax='B';break;
        	case 13: colMax='M'; rowMax='C';break;
        	case 14: colMax='N'; rowMax='D';break;
        	case 15: colMax='O'; rowMax='E';break;
        	case 16: colMax='P'; rowMax='F';break;
        	case 17: colMax='Q'; rowMax='G';break;
        	case 18: colMax='R'; rowMax='H';break;
        	case 19: colMax='S'; rowMax='I';break;
        	case 20: colMax='T'; rowMax='J';break;
        	case 21: colMax='U'; rowMax='K';break;
        	case 22: colMax='V'; rowMax='L';break;
        	case 23: colMax='W'; rowMax='M';break;
        	case 24: colMax='X'; rowMax='N';break;
        	case 25: colMax='Y'; rowMax='O';break;
        	case 26: colMax='Z'; rowMax='P';break;
		} // end switch
		
		for (int i=0; i<8; ++i) {
			col=fromCell.charAt(0);
			row=fromCell.charAt(1);
			switch (i)
			{
            	case 0: col=(char) (col+1); row=(char) (row+2);break;
            	case 1: col=(char) (col+2); row=(char) (row+1);break;
            	case 2: col=(char) (col+2); row=(char) (row-1);break;
            	case 3: col=(char) (col+1); row=(char) (row-2);break;
            	case 4: col=(char) (col-1); row=(char) (row-2);break;
            	case 5: col=(char) (col-2); row=(char) (row-1);break;
            	case 6: col=(char) (col-2); row=(char) (row+1);break;
            	case 7: col=(char) (col-1); row=(char) (row+2);break;
			} // end switch
			if (col>='A' && row>='1' && col<=colMax && row<=rowMax) {
				newSquare=Character.toString(col);
				newSquare+=row;
				System.out.println(newSquare);
			}
		}

	}

}
