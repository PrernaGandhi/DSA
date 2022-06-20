package advanced.convert_string_to_integer;

public class Runner {
    public static void main(String[] args) {
        ConvertStringToInteger convertStringToInteger = new ConvertStringToInteger();
        String string = "12345";
        System.out.println(convertStringToInteger.convert(string, string.length() - 1));
        string = "";
        System.out.println(convertStringToInteger.convert(string, string.length() - 1));
        string = "54321";
        System.out.println(convertStringToInteger.convert(string, string.length() - 1));
    }
}
