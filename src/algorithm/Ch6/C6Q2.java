package algorithm.Ch6;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C6Q2 {

    static int n;
    static PriorityQueue<Integer> q;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = new PriorityQueue<Integer>();
        arr = new int[n-1];

        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();
            q.add(t);
        }
        if(n==1) {
            System.out.println(q.peek());
            return;
        }
        execute();
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }
    static void execute() {
        for(int j=0; j< n-1; j++) {
            int low1 = q.poll();
            int low2 = q.poll();

            arr[j] = low1+low2;
            q.add(low1+low2);
        }
    }
}
