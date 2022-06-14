package quick_select;

public class Runner {
    public static void main(String[] args) {
        int[] arr = {2, -1, 5, 1, 7, 6, 8, 9};
        QuickSelect quickSelect = new QuickSelect(arr);
        // finding the 3rd smallest number
        System.out.println(quickSelect.quickSelect(3));

        // sort with quick select
        // we are targeting to put k form 1 to array.length
        // to sort the array
        for (int i = 1; i < arr.length; i++) {
            System.out.print(quickSelect.quickSelect(i) + " ");
        }
    }
}
