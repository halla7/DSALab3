public class KnightTour {
    private int N;

    public KnightTour(int size) {
        N = size;
    }

    public static void main(String[] args) {
        KnightTour kt = new KnightTour(8);
        kt.solve();
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
                System.out.print(ar[x][y] + " ");
                System.out.println();
            }
        }
    }

    public boolean solverUtil(int x, int y, int i, int sol[][], int xMoves[], int yMoves[]) {
        int k, next_x, next_y;
        if (i == N * N) {
            return true;
        }

        for (k = 0; k < N; k++) {
            next_x = x + xMoves[k];
            next_y = y + yMoves[k];
            if (isOpen(next_x, next_y, sol)) {
                sol[next_x][next_y] = i;
                if (solverUtil(next_x, next_y, i + 1, sol, xMoves, yMoves)) {
                    return true;
                } else {
                    sol[next_x][next_y] = -1;
                }
            }
        }
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
        if (!solverUtil(0, 0, 1, ar, horizontal, vertical)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            print(ar);
            return true;
        }


    }


}