package algorithm.Ch11;

import java.util.Scanner;

public class C11Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1) {
            System.out.println(1);
            return;
        }
        if(n == 2) {
            System.out.println(1);
            return;
        }
        int[] D = new int [90];
        D[1] = 2;
        D[2] = 3;
        for(int i = 3; i < n-1; i++) {
            D[i] = D[i-1] + D[i-2];
        }
        System.out.println(D[n-2]);
        sc.close();
    }
}
