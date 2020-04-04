package service;

import java.util.*;

public class Service {
    private static int TEST_NUMBER = 1_000_000;
//    private static int TEST_NUMBER = 1_0;
    public void start() {

        CounterCustom counterCustom1 = new CounterCustom();
        CounterCustom counterCustom2 = new CounterCustom();
        CounterCustom counterCustomForFirst = new CounterCustom();
        CounterCustom counterCustomForSecond = new CounterCustom();
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        Map<Integer, Integer> countForFirst = new HashMap<>();
        Map<Integer, Integer> countForSecond = new HashMap<>();

        List<Integer[]> result1 = new ArrayList<>(TEST_NUMBER);
        List<Integer[]> result2 = new ArrayList<>(TEST_NUMBER);


        RandomCustom randomCustom1 = new RandomCustom();
        int resultRandomCustom1;
        int resultRandomCustom2;


        for (int i = 0; i < TEST_NUMBER; i++) {
            int first = new Random().nextInt(5) + 1;
            counterCustomForFirst.count(countForFirst, first);
            int second = new Random().nextInt(5) + 1;
            counterCustomForSecond.count(countForSecond, second);

            resultRandomCustom1 = randomCustom1.rand7_1(first, second);
            Integer[] resultArray1 = new Integer[] {first, second, resultRandomCustom1};
            result1.add(resultArray1);
            counterCustom1.count(count1, resultRandomCustom1);

            resultRandomCustom2 = randomCustom1.rand7_2(first, second);
            Integer[] resultArray2 = new Integer[] {first, second, resultRandomCustom2};
            result2.add(resultArray2);
            counterCustom2.count(count2, resultRandomCustom2);
        }

//        showResults(result1, result2);

        System.out.println("for rand7");
        showStatistics(count1, count2);
        showDelta(counterCustom1, counterCustom2, count1, count2);

        System.out.println("for rand5");
        showStatistics(countForFirst, countForSecond);
        showDelta(counterCustomForFirst, counterCustomForSecond, countForFirst, countForSecond);


    }

    private void showDelta(CounterCustom counterCustom1, CounterCustom counterCustom2, Map<Integer, Integer> count1, Map<Integer, Integer> count2) {
        System.out.println("********************************************");
        System.out.println("               Delta");
        System.out.println("|          ||| Of method 1 | Of method 2 | ");
        System.out.println("|----------|||-------------|-------------| ");
        System.out.println(String.format("|  Delta   ||| %11d | %11d |", counterCustom1.countDelta(count1), counterCustom2.countDelta(count2)));
        System.out.println("|----------------------------------------| ");
        System.out.println("");
    }

    private void showStatistics(Map<Integer, Integer> count1, Map<Integer, Integer> count2) {
        System.out.println("********************************************");
        System.out.println("               Statistics");
        System.out.println("|  Element ||| In method 1 | In method 2 | ");
        System.out.println("|----------|||-------------|-------------| ");
        for (int i = 1; i <= 7; i++) {
            System.out.println(String.format("| %8d ||| %11d | %11d |", i, count1.get(i), count2.get(i)));
        }
        System.out.println("|----------------------------------------| ");
        System.out.println("");
    }

    private void showResults(List<Integer[]> result1, List<Integer[]> result2) {
        System.out.println("               ARRAY");
        System.out.println("| first  | second || method 1 | method 2 | ");
        System.out.println("|--------|--------||----------|----------| ");
        for (int i = 1; i < TEST_NUMBER; i++) {
            System.out.println(String.format("| %6d | %6d || %8d | %8d |", result1.get(i)[0], result1.get(i)[1], result1.get(i)[2], result2.get(i)[2]));
        }
        System.out.println("|----------------------------------------| ");
        System.out.println("");
    }
}
