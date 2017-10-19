
public class KnightTour {
	private int N;
	
	public KnightTour(int size) {
		N = size;
	}

	private boolean isOpen(int x, int y, int ar[][]) {
		boolean open = false;
		if (x >= 0 && x < N && y>= 0 && y < N && ar[x][y] == -1) { 
			open = true;
		} else {
			open = false;
		}
		return open;
	}
	
	public void print(int ar[][]) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				System.out.println(ar[x][y] + " ");
				System.out.println();
			}
		}
	}
	
	public boolean solverUtil(int x, int y, int i, int[] xMoves, int[] yMoves) {
		return false;
	}
	
	public boolean solve() {
		int ar[][] = new int[N][N];
		
		for (int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				ar[x][y] = -1;
			}
		}
		
		int horizontal[] = {2, 1, -1, -2, -2, -1, 1, 2};
		int vertical[] = {1, 2, 2, 1, -1, -2, -2, -1};
		
		ar[0][0] = 0;
		
		
		return false;
	}
	
	
}
