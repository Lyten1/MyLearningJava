package LeetCode;

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        if(numRows > 1) {
            StringBuilder result = new StringBuilder();
                int maxOffset = (numRows - 1) * 2;
                for (int start = 0; start < numRows; start++) {
                    int offset = (numRows - start - 1) * 2;

                    if (start == numRows - 1) {
                        offset = maxOffset;
                    }
                    int pointer = start;
                    while (pointer < s.length()) {
                        result.append(s.charAt(pointer));
                        pointer += offset;
                        if(offset < maxOffset) offset = maxOffset - offset;
                    }
                }
            return result.toString();
        }
        else {
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println( convert("PAYPALISHIRING", 4));
    }
}
