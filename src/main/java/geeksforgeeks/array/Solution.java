package geeksforgeeks.array;


import java.util.ArrayList;
import java.util.List;

class Hierarchy {

    String string;
    int countIndent;
    int height;
    List<Hierarchy> child;

    Hierarchy (String string, int countIndent, int height) {
        this.string = string;
        this.countIndent = countIndent;
        this.height = height;
        this.child = new ArrayList<>();
    }

}
public class Solution {

    public static void main(String args[]) {
        System.out.println("Hello World");
        String input = "public class PrettyPrint { public static void main(String args[]) { System.out.println(\"Hello World\"); String input = \"This is a sample code\"; if () { abc; bcde; cdfe; } System.out.println(Indent(input)); if () { abc; bcde; cdfe; } } public static String Indent(String input) { return \"Indented: \" + input; } }";
        System.out.println(Indent(input));

    }

    public static String Indent(String input) {

        StringBuilder indentedOutput = new StringBuilder("");

        Hierarchy root = null;
        int start = 0;
        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '{') {

                if (start == 0) {
                    root = new Hierarchy(input.substring(start, i + 1), 4, 1);
                }

            }

        }

        return indentedOutput.toString();

    }

}
