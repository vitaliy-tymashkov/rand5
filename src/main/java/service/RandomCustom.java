package service;

public class RandomCustom {

    public int rand7_1(int first, int second){
        return first + second % 3;
    }
    public int rand7_2(int first, int second){
        return ((first + second - 2) % 7) + 1;
    }
}
