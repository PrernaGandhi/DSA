package advanced.remove_character;

public class RemoveCharacter {
    public String remove(String string, char characterToBeRemoved, int currentIndex) {
        if (currentIndex == string.length()) {
            return string;
        }
        if (string.charAt(currentIndex) == characterToBeRemoved) {
            string = string.substring(0, currentIndex) + string.substring(currentIndex + 1);
        } else {
            currentIndex = currentIndex + 1;
        }
        string = remove(string, characterToBeRemoved, currentIndex);

        return string;
    }
}
