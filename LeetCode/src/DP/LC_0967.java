package DP;

import java.util.ArrayList;
import java.util.List;

public class LC_0967 {
    public static void main(String[] args) {
        Dolution d= new Dolution();
        System.out.println(d.numsSameConsecDiff(3,8));
    }
}
class Dolution {
    public int[] numsSameConsecDiff(int N, int K) {
        Integer[] array = {0,1,2,3,4,5,6,7,8,9};
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        int[] b = new int[100];
        if(N == 0){
            return a;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0,1);
        for(int i = 2; i <= N; i++){
            for(Integer m:array){
//                if(m % 10 + K < 10){
//                    list.add(m % 10 * 10 + m % 10 + K);
//                }
//                if(m % 10 - K >= 0 && K != 0){
//                    list.add(m % 10 * 10 + m % 10 + K);
//                }
            }
            array = list.toArray(array);
        }
//        int j = 0;
//        for(int i = 0; i < array.length; i++){
//            b[j++] = array[i];
//        }
        return b;
    }
}