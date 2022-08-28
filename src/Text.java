public class Text {
    public static void Print() {
        System.out.println();
    }

    public static void Print(String message) {
        System.out.println(message);
    }

    public static void Print(String message, Colour colour) {
        System.out.println(String.format("%s%s%s", colour.Get(), message, TextColour.RESET.Get()));
    }

    public static void PrintError(String message) {
        System.out.println(String.format("%s%s%s", TextColour.RED_BACKGROUND.Get(), message, TextColour.RESET.Get()));
    }
}
