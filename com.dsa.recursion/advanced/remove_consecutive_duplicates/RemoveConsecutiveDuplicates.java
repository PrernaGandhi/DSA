package advanced.remove_consecutive_duplicates;

public class RemoveConsecutiveDuplicates {
    public String remove(String string, int currentIndex) {
        if (currentIndex == string.length() - 1) {
            return string;
        }
        if (string.charAt(currentIndex) == string.charAt(currentIndex + 1)) {
            string = string.substring(0, currentIndex) + string.substring(currentIndex + 1);
        } else {
            currentIndex = currentIndex + 1;
        }
        string = remove(string, currentIndex);
        return string;
    }
}
