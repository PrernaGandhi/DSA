package graph_coloring;

/*
    We need to assign a color to each of the vertex of the graph
    Rules: No two adjacent vertex can have the same color

            A ------- B -- E
            | \     / |   /
            |  \   /  |  /
            |   \ /   | /
            |    C --- F
            |   /     /
            |  /    /
            | /   /
            |/  /
            ( D )

    With 3 colors:
            Let's assign colors now

            let's start with A -- > C1

            Now B, since B is adjacent to A,
            we can't assign C1 color so we assign C2

            Now C, let's try to give C C1,
            but since A is adjacent to C,
            we can't assign C1
            let's try C2, since C is adjacent to B,
            can't assign C2,
            so we assign C3 to C

            Now D, let's try C1,
            since A is adjacent to D we can't assign C1,
            let's try to assign C2,
            C2 works fine as B and D are not adjacent

            Now E, let's try with C1,
            since A and E are not connected,
            C1 works fine

            Now F, let's try C1,
            but E is adjacent to F,
            so let's try C2,
            but B and D are adjacent,
            so we need to choose another color,
            let's try C3,
            but C is connected to F,

            now we have no more colors left,
            so we backtrack,
            and reassign E
            with a new color, let's try C2
            but E is connected to B, so this doesn't work,
            let's try C3, it works fine

            Now F, let's try with C1,
            it works fine

        Output : A (C1)     B (C2)     C (C3)	    D (C2)	    E (C3)	    F (C1)

    With 4 colors:
            Let's assign colors now

            let's start with A -- > C1

            Now B, since B is adjacent to A,
            we can't assign C1 color so we assign C2

            Now C, let's try to give C C1,
            but since A is adjacent to C,
            we can't assign C1
            let's try C2, since C is adjacent to B,
            can't assign C2,
            so we assign C3 to C

            Now D, let's try C1,
            since A is adjacent to D we can't assign C1,
            let's try to assign C2,
            C2 works fine as B and D are not adjacent

            Now E, let's try with C1,
            since A and E are not connected,
            C1 works fine

            Now F, let's try C1,
            but E is adjacent to F,
            so let's try C2,
            but B and D are adjacent,
            so we need to choose another color,
            let's try C3,
            but C is connected to F,
            so let's apply a new color C4,

    Output : A (C1)	    B (C2)	    C (C3)	    D (C2)	    E (C1)	    F (C4)

 */
public class GraphColoring {
    int numberOfVertices;
    int numberOfColors;
    // this contains the solution
    // each index denotes the vertex no
    // each value denotes color no used
    int[] colors;
    int[][] graph;

    public GraphColoring(int[][] graph, int numberOfColors) {
        this.graph = graph;
        this.numberOfVertices = graph[0].length;
        this.numberOfColors = numberOfColors;
        this.colors = new int[numberOfVertices];
    }

    public void solve() {
        // if we are able to solve the problem starting with vertex 0
        // then show solution
        if (solveProblem(0)) {
            showSolution();
        } else {
            System.out.println("There is no valid solution with " + numberOfColors + " colors");
        }
    }

    private boolean solveProblem(int vertex) {
        // base case, end of algorithm
        // when are the vertex are assigned the colors
        if (vertex == numberOfVertices) {
            return true;
        }

        // try to include all the possible vertex in the graph
        for (int colorIndex = 1; colorIndex <= numberOfColors; colorIndex++) {
            // if color is valid,
            // assign the color to the vertex
            if (isColorValid(vertex, colorIndex)) {
                colors[vertex] = colorIndex;
                // try to solve for the next vertex
                if (solveProblem(vertex + 1)) {
                    return true;
                }

                //BACKTRACK
                // do nothing
            }
        }
        return false;
    }

    private boolean isColorValid(int vertex, int color) {
        // check all the adjacent vertices and check if they have the same color
        // iterate over the graph, check if the vertices are connected,
        // then the color is not valid for this vertex
        for (int i = 0; i < numberOfVertices; i++) {

            // it means the i vertex is connected to the given vertex
            if (graph[vertex][i] == 1) {
                // connected vertices with same color
                if (colors[i] == color) {
                    return false;
                }
            }
        }
        return true;
    }

    private void showSolution() {
        System.out.println("Solution with " + numberOfColors + " colors");
        for (int i = 0; i < colors.length; i++) {
            System.out.print((i + 1) + " (" + colors[i] + ")" + "\t");
        }
    }
}
