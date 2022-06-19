package easy.tower_of_hanoi;

public class Runner {
    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.solve(2, 'A', 'B', 'C');
    }
}