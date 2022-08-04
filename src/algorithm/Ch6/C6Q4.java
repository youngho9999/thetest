package algorithm.Ch6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C6Q4 {

    static int n;
    static boolean[] hour = new boolean[24];
    static int answer;

    static Map<Integer,Integer> end = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            if(end.containsKey(r)) {
                int forCompare = end.get(r);
                if(l > forCompare) {
                    end.replace(r, l);
                }
            }
            else {
                end.put(r,l);
            }
        }
        //입력완료
        for(int i = 0; i < 24; i++) {
            if(!end.containsKey(i)) {
                continue;
            }
            else {
                int start = end.get(i);
                if(checkTime(start, i)) {
                    answer++;
                    color(start, i);
                }
            }
        }
        System.out.println(answer);


    }
    static boolean checkTime(int start, int end) {
        for(int t = start; t < end; t++) {
            if(hour[t] == true) {
                return false;
            }
        }
        return true;
    }

    static void color(int start, int end) {
        for(int i = start; i < end; i++) {
            hour[i] = true;
        }
    }
}
