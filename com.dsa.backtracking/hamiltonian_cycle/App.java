package hamiltonian_cycle;

public class App {
    public static void main(String[] args) {
        int [] [] adjacencyMatrix = {
                {0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0},
        };
        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle(adjacencyMatrix);
        hamiltonianCycle.solve();
    }
}
