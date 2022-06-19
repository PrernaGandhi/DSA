package intermediate.all_positions_of_element;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        AllPositionsOfElement allPositionsOfElement = new AllPositionsOfElement();
        int[] array = {1, 2, 3, 5, 4, 5, 5};
        allPositionsOfElement.getAllPositionsOfElement(array, array.length - 1, 5);
        System.out.println();
        allPositionsOfElement.getAllPositionsOfElement(array, array.length - 1, 2);

        System.out.println();
        System.out.println(allPositionsOfElement.returnAllPositionsOfElement(array, array.length - 1, 5, new ArrayList<>()));
        System.out.println(allPositionsOfElement.returnAllPositionsOfElement(array, array.length - 1, 2, new ArrayList<>()));

    }
}
