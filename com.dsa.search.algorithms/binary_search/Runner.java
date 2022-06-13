package binary_search;

public class Runner {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.iterativeSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
        System.out.println(binarySearch.iterativeSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        System.out.println(binarySearch.iterativeSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1));
        System.out.println(binarySearch.iterativeSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2));
        System.out.println(binarySearch.iterativeSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 6));
        System.out.println(binarySearch.iterativeSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, -1));
        System.out.println("=================================================");
        System.out.println(binarySearch.recursiveHeadSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9, 0, 5, 10));
        System.out.println(binarySearch.recursiveHeadSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 0, 5, 10));
        System.out.println(binarySearch.recursiveHeadSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1, 0, 5, 10));
        System.out.println(binarySearch.recursiveHeadSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2, 0, 5, 10));
        System.out.println(binarySearch.recursiveHeadSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 6, 0, 5, 10));
        System.out.println(binarySearch.recursiveHeadSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, -1, 0, 5, 10));
        System.out.println("=================================================");
        System.out.println(binarySearch.recursiveTailSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9, 0, 5, 10));
        System.out.println(binarySearch.recursiveTailSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 0, 5, 10));
        System.out.println(binarySearch.recursiveTailSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1, 0, 5, 10));
        System.out.println(binarySearch.recursiveTailSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2, 0, 5, 10));
        System.out.println(binarySearch.recursiveTailSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 6, 0, 5, 10));
        System.out.println(binarySearch.recursiveTailSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, -1, 0, 5, 10));
    }
}
