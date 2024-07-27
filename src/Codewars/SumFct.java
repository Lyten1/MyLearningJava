package Codewars;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SumFct {


    public static BigInteger perimeter(BigInteger n) {
        List<BigInteger> fibonacciNums = new ArrayList<>();
        fibonacciNums.add(BigInteger.ZERO);
        fibonacciNums.add(BigInteger.ONE);
        int num = n.intValue();
        for (int i = 0; i < num ; i++){
            fibonacciNums.add(fibonacciNums.get(i).add(fibonacciNums.get(i+1)));
        }
        return BigInteger.valueOf(4).multiply(fibonacciNums.stream().reduce(BigInteger.ZERO, (a,b) -> a.add(b)));
    }
}
 