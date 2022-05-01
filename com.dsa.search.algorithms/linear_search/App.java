package linear_search;

public class App {
    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        System.out.println(linearSearch.iterativeSearch(new int[]{1, 5, 30, 2, 70, 199, 100}, 2));
        System.out.println(linearSearch.recursiveSearch(new int[]{1, 5, 30, 2, 70, 199, 100}, 2, 0));
    }
}