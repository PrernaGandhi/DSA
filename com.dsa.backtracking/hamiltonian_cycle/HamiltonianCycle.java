package hamiltonian_cycle;

public class HamiltonianCycle {
    int numOfVertices;
    int [] hamiltonianPath;
    int [][] adjacencyMatrix;

    public HamiltonianCycle(int [][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numOfVertices = adjacencyMatrix[0].length;
        this.hamiltonianPath = new int[numOfVertices];
    }

    public void solve() {
        hamiltonianPath[0] = 0;
        if(findSolution(1)) {
            showSolution();
        } else {
            System.out.println("There is no solution ......... ");
        }
    }

    private boolean findSolution(int position) {

        // base case, if we have reached end of algorithm, it means we have considered all the vertices
        if(position == numOfVertices) {
            // we check if the last position of hamiltonian path is connected to the
            // starting vertex of the hamiltonian path
            if(adjacencyMatrix[hamiltonianPath[position -1]][hamiltonianPath[0]] == 1)
                return true;
            else
                return false;
        }

        // try to include all the possible vertex in the graph
        for(int vertexIndex = 1; vertexIndex < numOfVertices; vertexIndex ++) {
            // if this vertex is valid then this is the next in the hamiltonian path
            if(isValid(vertexIndex, position)) {
                // add vertex to hamiltonian path
                hamiltonianPath[position] = vertexIndex;

                if(findSolution(position + 1))
                    return true;

                // BACKTRACK If we are not able to find the solution
                // in this case we don't have to do anything to back track
            }
        }

        return false;
    }

    private boolean isValid(int vertexId, int actualPosition) {

        // check if the two vertices are connected or not
        if(adjacencyMatrix[hamiltonianPath[actualPosition -1]][vertexId] == 0)
            return false;

        // check if we have already visited that vertex
        for (int i = 0; i < actualPosition; i++) {
            if(hamiltonianPath[i] == vertexId)
                return false;
        }

        return true;
    }

    private void showSolution() {
        System.out.println("Hamiltonian Cycle exists");
        for (int element : hamiltonianPath)
            System.out.print(element + " -> ");

        System.out.println(hamiltonianPath[0]);
    }
}
