package intermediate.all_positions_of_element;

import java.util.List;

public class AllPositionsOfElement {
    public void getAllPositionsOfElement(int[] array, int currentIndex, int searchElement) {
        if (currentIndex == -1) {
            return;
        }

        getAllPositionsOfElement(array, currentIndex - 1, searchElement);

        if (array[currentIndex] == searchElement) {
            System.out.print(currentIndex + " ");
            // if we need to return the list,
            // we add one more parameter and at this step
            // add to the list and in the end return the list
        }
    }

    public List<Integer> returnAllPositionsOfElement(int[] array, int currentIndex, int searchElement, List<Integer> list) {
        if (currentIndex == -1) {
            return list;
        }

        returnAllPositionsOfElement(array, currentIndex - 1, searchElement, list);

        if (array[currentIndex] == searchElement) {
            // if we need to return the list,
            // we add one more parameter and at this step
            // add to the list and in the end return the list
            list.add(currentIndex);
        }
        return list;
    }
}
