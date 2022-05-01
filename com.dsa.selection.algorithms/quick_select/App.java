package quick_select;

public class App {
    public static void main(String[] args) {
        QuickSelect quickSelect = new QuickSelect(new int[]{2, -1, 5, 1, 7, 6, 8, 9});
        System.out.println(quickSelect.quickSelect(3));

        // sort with quick select
        for(int i = 1;i < 9;i++) {
            System.out.print(quickSelect.quickSelect(i) + " ");
        }
    }
}
