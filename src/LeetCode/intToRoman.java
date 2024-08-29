package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class intToRoman {

    private static final int ONE = 1;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int NINE = 9;
    public static void main(String[] args) {
        System.out.println( intToRoman(1994));
        System.out.println( intToRoman(3749));
    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        int workOnNum = num;
        int zeros = 0;
        while (true){
            numbers.add(workOnNum % 10);
            workOnNum /= 10;
            zeros++;
            if(workOnNum < 1) break;
        }
        Collections.reverse(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            int curr_num = numbers.get(i);

            if(curr_num != ONE && curr_num != FOUR && curr_num != FIVE && curr_num != NINE) {
                if(curr_num > FOUR) {
                    sb.append(transformOneDecadToRoman(FIVE, numbers.size() - i - 1));
                    curr_num -= 5;
                }
                sb.append(transformOneDecadToRoman(ONE, numbers.size() - i - 1).repeat(Math.max(0, curr_num)));
            }
            else{

                sb.append(transformOneDecadToRoman(curr_num, numbers.size() - i - 1));
            }
        }

        return sb.toString();
    }



    public static String transformOneDecadToRoman(int num, int pow){

        if(num == 1){
            switch (pow){
                case 0: return "I";
                case 1: return "X";
                case 2: return "C";
                case 3: return "M";
            }
        }
        else if(num == 4){
            switch (pow){
                case 0: return "IV";
                case 1: return "XL";
                case 2: return "CD";
            }
        }
        else if(num == 9){
            switch (pow){
                case 0: return "IX";
                case 1: return "XC";
                case 2: return "CM";
            }
        }
        else if(num == 5){
            switch (pow){
                case 0: return "V";
                case 1: return "L";
                case 2: return "D";
            }
        }
        return "";
    }
}
