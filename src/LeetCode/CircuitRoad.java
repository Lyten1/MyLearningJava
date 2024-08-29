package LeetCode;

public class CircuitRoad {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentFill;
        int counterOfZeroWay = 0;
        for(int i = 0; i < gas.length; i++){
            currentFill = gas[i];
            if(gas[i] == cost[i]){
                counterOfZeroWay++;
                continue;
            }
            int circle = 0;
            for (int j = i; true;){
                int nextJ = j+1 == gas.length ? 0 : j+1;

                if(j == i){
                    if(circle == 1)
                        return i;
                    circle++;
                }


                currentFill -= cost[j];
                if(currentFill >= 0) currentFill += gas[nextJ];
                if(currentFill < 0 ) break;
                j = nextJ;

            }
        }
        if(counterOfZeroWay == gas.length) return 0;
        return -1;
    }
}
