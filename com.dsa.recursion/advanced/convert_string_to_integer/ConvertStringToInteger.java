package advanced.convert_string_to_integer;

public class ConvertStringToInteger {
    public int convert(String string, int currentIndex) {
        if (currentIndex == -1) {
            return 0;
        }

        int result = convert(string, currentIndex - 1);
        return (int) (result + Integer.parseInt(String.valueOf(string.charAt(currentIndex))) * Math.pow(10, string.length() - currentIndex - 1));
    }
}
