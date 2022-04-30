package tower_of_hanoi;

public class TowerOfHanoi {
    public void solve(int disk, char source, char middle, char destination) {
        if(disk == 0) {
            System.out.println("Plate : " + disk + " from " + source + " to " + destination);
            return;
        }
        solve(disk-1, source, destination, middle);
        System.out.println("Plate : " + disk + " from " + source + " to " + destination);
        solve(disk-1, middle, source, destination);
    }

}
