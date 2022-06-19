package intermediate.last_index_of_element;


public class Runner {
    public static void main(String[] args) {
        LastIndexOfElement lastIndexOfElement = new LastIndexOfElement();
        int[] array = {1, 2, 3, 5, 4, 5, 5};
        System.out.println(lastIndexOfElement.find(array, array.length - 1, 5));
        System.out.println(lastIndexOfElement.find(array, array.length - 1, 2));
        System.out.println(lastIndexOfElement.find(array, array.length - 1, 10));
    }
}
