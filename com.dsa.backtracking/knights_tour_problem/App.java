package knights_tour_problem;

public class App {
    public static void main(String[] args) {
        KnightsTour problem = new KnightsTour(4);
        problem.solve();
        problem = new KnightsTour(5);
        problem.solve();
    }
}
