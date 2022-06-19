package intermediate.first_index_of_element;

public class Runner {
    public static void main(String[] args) {
        FirstIndexOfElement firstIndexOfElement = new FirstIndexOfElement();
        int[] array = {1, 2, 3, 5, 4, 5, 5};
        System.out.println(firstIndexOfElement.find(array, 0, 5));
        System.out.println(firstIndexOfElement.find(array, 0, 2));
        System.out.println(firstIndexOfElement.find(array, 0, 10));
    }
}
