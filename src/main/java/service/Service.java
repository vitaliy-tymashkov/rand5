package service;

import java.util.*;

public class Service {
    private static int TEST_NUMBER = 1_000_000;
//    private static int TEST_NUMBER = 1_0;
    public void start() {

        CounterCustom counterCustom1 = new CounterCustom();
        Map<Integer, Integer> count1 = new HashMap<>();
        List<Integer[]> result1 = new ArrayList<>(TEST_NUMBER);

        CounterCustom counterCustom2 = new CounterCustom();
        Map<Integer, Integer> count2 = new HashMap<>();
        List<Integer[]> result2 = new ArrayList<>(TEST_NUMBER);

        CounterCustom counterCustom3 = new CounterCustom();
        Map<Integer, Integer> count3 = new HashMap<>();
        List<Integer[]> result3 = new ArrayList<>(TEST_NUMBER);

        CounterCustom counterCustomForFirst = new CounterCustom();
        Map<Integer, Integer> countForFirst = new HashMap<>();

        CounterCustom counterCustomForSecond = new CounterCustom();
        Map<Integer, Integer> countForSecond = new HashMap<>();

        CounterCustom counterCustomForThird = new CounterCustom();
        Map<Integer, Integer> countForThird = new HashMap<>();



        RandomCustom randomCustom1 = new RandomCustom();
        int resultRandomCustom1;
        int resultRandomCustom2;
        int resultRandomCustom3;


        for (int i = 0; i < TEST_NUMBER; i++) {

            int first = new Random().nextInt(5) + 1;
            counterCustomForFirst.count(countForFirst, first);

            int second = new Random().nextInt(5) + 1;
            counterCustomForSecond.count(countForSecond, second);

            int third = new Random().nextInt(5) + 1;
            counterCustomForThird.count(countForThird, third);

            resultRandomCustom1 = randomCustom1.rand7_1(first, second);
            Integer[] resultArray1 = new Integer[] {first, second, resultRandomCustom1};
            result1.add(resultArray1);
            counterCustom1.count(count1, resultRandomCustom1);

            resultRandomCustom2 = randomCustom1.rand7_2(first, second);
            Integer[] resultArray2 = new Integer[] {first, second, resultRandomCustom2};
            result2.add(resultArray2);
            counterCustom2.count(count2, resultRandomCustom2);

            resultRandomCustom3 = randomCustom1.rand7_3(first);
            Integer[] resultArray3 = new Integer[] {first, second, resultRandomCustom3};
            result3.add(resultArray3);
            counterCustom3.count(count3, resultRandomCustom3);
        }

//        showResults(result1, result2);

        System.out.println("            for rand7");
        showStatistics(count1, count2, count3);
        showDelta(counterCustom1, counterCustom2, counterCustom3, count1, count2, count3);


//        System.out.println("            for rand5");
//        showStatistics(countForFirst, countForSecond, countForThird);
//        showDelta(counterCustomForFirst, counterCustomForSecond, counterCustomForThird, countForFirst, countForSecond, countForThird);


    }

    private void showDelta(CounterCustom counterCustom1, CounterCustom counterCustom2, CounterCustom counterCustom3,
                           Map<Integer, Integer> count1, Map<Integer, Integer> count2, Map<Integer, Integer> count3) {
        System.out.println("*******************************************************");
        System.out.println("               Delta in %");
        System.out.println("|          ||| Of method 1 | Of method 2 | Of method 3 | ");
        System.out.println("|----------|||-------------|-------------|-------------| ");
        System.out.println(String.format("|  Delta   ||| %11.2f | %11.2f | %11.2f |",
                (double) counterCustom1.countDelta(count1)*100/TEST_NUMBER,
                (double) counterCustom2.countDelta(count2)*100/TEST_NUMBER,
                (double) counterCustom3.countDelta(count3)*100/TEST_NUMBER));
        System.out.println("|----------|||-------------|-------------|-------------| ");
        System.out.println("");
    }

    private void showStatistics(Map<Integer, Integer> count1, Map<Integer, Integer> count2, Map<Integer, Integer> count3) {
        System.out.println("*******************************************************");
        System.out.println("               Statistics");
        System.out.println("|  Element ||| In method 1 | In method 2 | In method 3 | ");
        System.out.println("|----------|||-------------|-------------|-------------| ");
//        for (int i = 1; i <= 7; i++) {
        for (int i = 0; i <= 8; i++) {
            System.out.println(String.format("| %8d ||| %11d | %11d | %11d |", i, count1.get(i), count2.get(i), count3.get(i)));
        }
        System.out.println("|----------|||-------------|-------------|-------------| ");
        System.out.println("");
    }

    private void showResults(List<Integer[]> result1, List<Integer[]> result2) {
        System.out.println("               ARRAY");
        System.out.println("| first  | second || method 1 | method 2 | ");
        System.out.println("|--------|--------||----------|----------| ");
        for (int i = 1; i < TEST_NUMBER; i++) {
            System.out.println(String.format("| %6d | %6d || %8d | %8d |", result1.get(i)[0], result1.get(i)[1], result1.get(i)[2], result2.get(i)[2]));
        }
        System.out.println("|--------|--------||----------|----------| ");
        System.out.println("");
    }
}
