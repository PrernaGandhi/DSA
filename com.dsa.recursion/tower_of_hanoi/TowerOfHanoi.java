package tower_of_hanoi;

/*

         (_D3_)
       (___D2___)
      (____D1____)
    _______|_______    _______|_______    _______|_______
        Source           Middle           Destination

        Step 1 :


       (___D2___)
      (____D1____)         (_D3_)
    _______|_______    _______|_______    _______|_______
        Source           Middle           Destination

        Step 2 :



      (____D1____)         (_D3_)           (___D2___)
    _______|_______    _______|_______    _______|_______
        Source           Middle           Destination

        Step 3 :


                                               (_D3_)
      (____D1____)                           (___D2___)
    _______|_______    _______|_______    _______|_______
        Source           Middle           Destination

        Step 4 :


                           (_D3_)
      (____D1____)       (___D2___)
    _______|_______    _______|_______    _______|_______
        Source           Middle           Destination

        Step 5 :



                           (_D3_)
                         (___D2___)        (____D1____)
    _______|_______    _______|_______    _______|_______
        Source           Middle           Destination

        Step 6:


                                              (_D3_)
                                            (___D2___)
                                           (____D1____)
    _______|_______    _______|_______    _______|_______
        Source           Middle           Destination


 */
public class TowerOfHanoi {
    public void solve(int disk, char source, char middle, char destination) {
        if (disk == 0) {
            System.out.println("Plate : " + disk + " from " + source + " to " + destination);
            return;
        }
        // we try to solve for n - 1 disks by trying to move n - 1 disks
        // from the source to the middle position with the help of the destination
        solve(disk - 1, source, destination, middle);
        // then we move the last disk at source from source to destination
        System.out.println("Plate : " + disk + " from " + source + " to " + destination);
        // then we try to move the n - 1 disks from the middle to the destination
        solve(disk - 1, middle, source, destination);
    }
}
