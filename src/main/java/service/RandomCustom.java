package service;

public class RandomCustom {

    //Normal delta for java random = 0.05%

    public int rand7_1(int first, int second){
        return first + second % 3;                  //DELTA = 16% - most used = from 2 to 6
    }

    public int rand7_2(int first, int second){
        return ((first + second - 2) % 7) + 1;      //DELTA = 8% - most used = 5
//        return ((first + second) % 7) + 1;        //DELTA = 8% - most used = 7
    }

    public int rand7_3(int first){
//        return 1;                                 // missing 2-7 (delta 0%)
//        return first;                             // missing 6, 7 (delta 0.05%)
//        return (int) (Math.round(first * 1.4));   // missing 2, 5 (delta 0.15%)
//        return (int) (first*1.4) % 8;             // missing 3, 6 (delta 0.15%)
//        return (((first - 1) * 2) % 7) + 1;       // missing 4, 6 (delta 0.05%)
//        return (first*10) % 7 + 1;                // missing 1, 5 (delta 0.02%)
//        return ((first - 1) * 2) % 7 + 1;         // missing 4, 6 (delta 0.10%)
//        return ((first - 1) * 222) % 7 + 1;       // missing 3, 5 (delta 0.07%)
//        return first + (first - 1) % 3;           //missing 2, 7 (delta 0.12%)
//        return first + (first) % 2;               //missing 1, 3, 5, 7 (delta 20%)
//        return first + (first) % 3;               //missing 1, 6 (delta 0.08%)
//        return first + (first-1) % 3;             //missing 2, 7 (delta 0.13%)
//        return first + (first-1) % 2;             //missing 2, 4, 6, 7 (delta 20%)
//        return ((first-1)%3 + (first-1)%4) + 1;   //missing 6, 7 (delta 0.08%)
//        return ((first-1)%3 ) + 1;   //missing 4- 7 (delta 20%)
//        return (((first-1)%2 + (first-1)%3 + (first-1)%4 + (first-1)%5))%7 + 1;             //missing 6, 7 (delta 0.08%)

        /*
        1 2 3 4 5
        0001-0010-0011-0100-0101
        000-100-100-011-010-001-01
        0000-0100-0100-0011-0010-0001-0001
        0 4 4 3 2 1 1

            1 2 3 4 5 6 7

        1.4
        2.8
        4.2
        5.8
        7.0

        */
        double worker = (first) * Math.PI;

        int result = 0;



        String workerString = String.valueOf(worker).replace(".","").substring(0,15);
        int length = workerString.length();

        for (int i = 0; i < length; i++){
            char c = workerString.charAt(i);
            result = result + c;
        }



        return result % 7 + 1;
    }

}
