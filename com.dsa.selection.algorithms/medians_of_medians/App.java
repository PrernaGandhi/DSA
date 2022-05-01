package medians_of_medians;

public class App {
    public static void main(String[] args) {
        MediansOfMedians mediansOfMedians = new MediansOfMedians(new int[]{2, -1, 5, 1, 7, 6, 8, 9});
        System.out.println(mediansOfMedians.quickSelect(3));
        mediansOfMedians = new MediansOfMedians(new int[]{1, -2, 5, 8, 7, 6, 10, 4, 18, 2, 3, -4, 55,0, 11});
        System.out.println(mediansOfMedians.quickSelect(3));
        System.out.println(mediansOfMedians.quickSelect(5));
        System.out.println(mediansOfMedians.quickSelect(8));
        System.out.println(mediansOfMedians.quickSelect(15));

    }
}
