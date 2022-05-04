package maze_problem;

public class App {
    public static void main(String[] args) {
        int [][] mazeBoard = {
                {0, 0, 0, 0},
                {0, -1, 0, -1},
                {-1, -1, 0, 0},
                {0, -1, 0, 0}
        };
        MazeProblem mazeProblem = new MazeProblem(mazeBoard);
        mazeProblem.solve();
    }
}
