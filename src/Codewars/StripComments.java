package Codewars;

import com.sun.jdi.request.StepRequest;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StripComments {

    @Test
    public static void main(String[] args) {

        assertEquals( "apples, pears\ngrapes\nbananas", stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" }));
        assertEquals( "a\n b\nc", stripComments("a \n b \nc ", new String[] { "#", "!" }));


    }
    public static String stripComments(String text, String[] commentSymbols) {
        if (commentSymbols.length == 0) {
            return text.trim();
        }
        System.out.println("Example");
        for (char key : text.toCharArray()
        ) {
            if (key == '\n') {
                System.out.print("\\n");
            } else if (key == ' ') {
                System.out.print("_");
            } else
                System.out.print(key);
        }
        String nl = "\n";
        int begin = 0;
        int lastLetter = 0;

        StringBuilder redoText = new StringBuilder();


        String findNLs = text;
        for (int i = 0; i < text.chars().filter(ch -> ch == '\n').count() + 1; i++) {
            String tempLine;
            int nlPos = findNLs.indexOf(nl);
            if (nlPos == -1)
                tempLine = findNLs;
            else
                tempLine = findNLs.substring(0, nlPos);
            int j = 0;
            for (char ch : tempLine.toCharArray()) {
                j++;
                if (Arrays.stream(commentSymbols).toList().contains(Character.toString(ch))) {
                    break;
                } else if (ch != ' ') {
                    lastLetter = j;
                }

            }

            redoText.append(tempLine.substring(0, lastLetter));
            if (nlPos != -1)
                redoText.append("\n");
            begin = nlPos + 1;
            findNLs = findNLs.substring(begin);
        }
        System.out.println();
        for (char key : redoText.toString().toCharArray()
        ) {
            if (key == '\n') {
                System.out.print("\\n");
            } else if (key == ' ') {
                System.out.print("_");
            } else
                System.out.print(key);
        }
        System.out.println();
        return redoText.toString();
    }

    public static String removeSpacesBeforeNL(String text){
//        if(text.charAt(text.length()-1) == '\n') {
        System.out.println("function: "+ text);
            StringBuilder result = new StringBuilder();
            int i = text.length() - 2;
            while (text.charAt(i) == ' ') {
                i--;
            }
            result.append(text.substring(0, i + 1));
            result.append('\n');
            return result.toString();
//        }
//        else
//            throw new RuntimeException("No new line at the end");
    }

}
