package n_queens;

public class Runner {
    public static void main(String[] args) {
        NQueens nQueens = new NQueens(3);
        nQueens.solve();
        NQueens nQueens1 = new NQueens(5);
        nQueens1.solve();
    }
}
