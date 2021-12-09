package pl.lukwas;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParenthesisChecker {

    public static boolean isValid(String text) {
        if (text.isEmpty()) {
            return true;
        }
        String simplifiedText = simplify(text);
        if (simplifiedText.length() < text.length()) {
            return isValid(simplifiedText);
        } else {
            return false;
        }
    }

    private static String simplify(String text) {
        return text.replaceAll("(\\(\\)|\\{}|\\[])", "");
    }
}
