package mediapresentation.util;

/** Hilfsklasse für die Einrückung der Konsolenausgabe. */
public final class Indentation {
    private Indentation() {}

    public static String of(int level) {
        return "    ".repeat(level);
    }
}