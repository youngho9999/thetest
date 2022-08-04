package algorithm.Ch6;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C6Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> positive= new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative= new PriorityQueue<>();
        int count_1 = 0;
        int count_0 = 0;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if(temp>1) {
                positive.add(temp);
            }
            else if(temp == 1) {
                count_1++;
            }
            else if(temp == 0) {
                count_0++;
            }
            else {
                negative.add(temp);
            }
        }
        int positive_count = positive.size()/2;
        int negative_count = negative.size()/2;


        for(int i = 0; i < positive_count; i++) {
            int t1 = positive.poll();
            int t2 = positive.poll();
            int t3 = t1*t2;
            sum += t3;
        }
        if(!positive.isEmpty()) {
            sum += positive.poll();
        }

        sum += count_1;

        for(int i = 0; i < negative_count; i++) {
            int t1 = negative.poll();
            int t2 = negative.poll();
            int t3 = t1*t2;
            sum += t3;
        }
        if(!negative.isEmpty()) {
            if(count_0>0) {
                System.out.println(sum);
                return;
            }
            else if(count_0 == 0) {
                sum += negative.poll();
                System.out.println(sum);
                return;
            }
        }
        else {
            System.out.println(sum);
        }


    }
}
