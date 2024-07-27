package simulations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PrisonSimalation {

    public static class Prisoner{
        int number;
        boolean free;

        Prisoner(int number){
            this.number = number;
            this.free = false;
        }

        public void setFree(boolean free) {
            this.free = free;
        }
    }

    final static int COUNT_PRISONERS = 100;
    final static int COUNT_TRIES = 50;
    static int [] boxes = new int[COUNT_PRISONERS];


    public static void fillBoxes (){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < COUNT_PRISONERS; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        for (int i = 0; i < COUNT_PRISONERS; i++) {
            boxes[i] = numbers.get(i);
        }

    }


    public static boolean feelFreeByChain(){
        List<Prisoner> prisonerList = new ArrayList<>();
        for (int i = 0; i < COUNT_PRISONERS; i++){
            prisonerList.add(new Prisoner(i));
        }
        for (int i = 0; i < COUNT_PRISONERS; i++){
            chainBehavior(prisonerList.get(i));
        }
        return prisonerList.stream().filter((obj) -> obj.free).count() == COUNT_PRISONERS;
    }

    public static void chainBehavior(Prisoner prisoner){
        int checkBox = prisoner.number;
        for (int j = 0; j < COUNT_TRIES; j++) {
            if (boxes[checkBox] == prisoner.number){
                prisoner.setFree(true);
                break;
            }
            else
                checkBox = boxes[checkBox];
        }
    }

    public static boolean feelFreeByRandom(){
        List<Prisoner> prisonerList = new ArrayList<>();
        for (int i = 0; i < COUNT_PRISONERS; i++){
            prisonerList.add(new Prisoner(i));
        }
        for (int i = 0; i < COUNT_PRISONERS; i++){
            randomBehavior(prisonerList.get(i));
        }
        return prisonerList.stream().filter((obj) -> obj.free).count() == COUNT_PRISONERS;
    }

    public static void randomBehavior(Prisoner prisoner){
        Random rand = new Random();
        List<Integer> boxLeave = new ArrayList<>();
        for (int i = 0; i < COUNT_PRISONERS ; i++){
            boxLeave.add(i);
        }
        int checkBox;
        for (int i = 0; i < COUNT_TRIES; i++){
            checkBox = rand.nextInt(boxLeave.size());
            if(boxes[boxLeave.get(checkBox)] == prisoner.number) {
                prisoner.setFree(true);
                break;
            }
            boxLeave.remove(checkBox);
        }
    }

    public static boolean feelFreeByNextTries(){
        List<Prisoner> prisonerList = new ArrayList<>();
        for (int i = 0; i < COUNT_PRISONERS; i++){
            prisonerList.add(new Prisoner(i));
        }
        for (int i = 0; i < COUNT_PRISONERS; i++){
            nextTriesBehavior(prisonerList.get(i));
        }
        return prisonerList.stream().filter((obj) -> obj.free).count() == COUNT_PRISONERS;
    }

    public static void nextTriesBehavior(Prisoner prisoner){
        int checkBox = prisoner.number;
       for(int i = 0; i < COUNT_TRIES; i++){
           if (boxes[checkBox] == prisoner.number) {
               prisoner.setFree(true);
               break;
           }

           if(checkBox+1 == COUNT_PRISONERS)
               checkBox = 0;
           else
               checkBox++;
       }
    }

    public static void main(String[] args) {

        final int EXPERIMENT_COUNTS = 100000;

        int countTrue = 0;
        int countFalse = 0;
        for (int i =0; i< EXPERIMENT_COUNTS; i++) {
            fillBoxes();
            if(feelFreeByChain())
                countTrue++;
            else
                countFalse++;
        }
        System.out.println("Chain bahavior");
        System.out.println("Count of success tries: " + countTrue);
        System.out.println("Count of failed tries: " + countFalse);

        countTrue = 0;
        countFalse = 0;
        for (int i =0; i< EXPERIMENT_COUNTS; i++) {
            fillBoxes();
            if(feelFreeByRandom())
                countTrue++;
            else
                countFalse++;
        }
        System.out.println("Random bahavior");
        System.out.println("Count of success tries: " + countTrue);
        System.out.println("Count of failed tries: " + countFalse);

        countTrue = 0;
        countFalse = 0;
        for (int i =0; i< EXPERIMENT_COUNTS; i++) {
            fillBoxes();
            if(feelFreeByNextTries())
                countTrue++;
            else
                countFalse++;
        }
        System.out.println("Next tries bahavior");
        System.out.println("Count of success tries: " + countTrue);
        System.out.println("Count of failed tries: " + countFalse);

    }
}
