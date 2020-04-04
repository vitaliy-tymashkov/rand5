package service;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class CounterCustom {
    public void count(Map<Integer, Integer> counter, int value){
        if (counter.containsKey(value)){
            int oldValue = counter.get(value);
            counter.put(value, oldValue + 1);
        } else {
            counter.put(value, 1);
        }
    }

    public Integer countDelta(Map<Integer,Integer> counter){

        Integer result = 0;
        Integer max = maxUsingStreamAndMethodReference(counter);
        Integer min = minUsingStreamAndMethodReference(counter);

/*        for (int i = 1; i <= 7; i++ ){
            Integer value = counter.get(i);
            if (value == null){
                return null;
            }
        }*/
        result = Math.abs(max-min);

        return result;
    }

    public <K, V extends Comparable<V>> V maxUsingStreamAndMethodReference(Map<K, V> map) {
        Optional<Map.Entry<K, V>> maxEntry = map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        return maxEntry.get()
                .getValue();
    }

    public <K, V extends Comparable<V>> V minUsingStreamAndMethodReference(Map<K, V> map) {
        Optional<Map.Entry<K, V>> minEntry = map.entrySet()
                .stream()
                .min(Comparator.comparing(Map.Entry::getValue));
        return minEntry.get()
                .getValue();
    }
}
