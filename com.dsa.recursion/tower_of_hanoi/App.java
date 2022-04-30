package tower_of_hanoi;

public class App {
    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.solve(2, 'A', 'B', 'C' );
    }
}