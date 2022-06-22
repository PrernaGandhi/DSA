package advanced.staircase_problem;

/*
    We need to find number of ways to reach step N using steps 1, 2 and 3
 */
public class StaircaseProblem {
    public int solve(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return solve(n - 3) + solve(n - 2) + solve(n - 1);
    }
}
