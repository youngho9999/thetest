package algorithm.Ch11;

import java.util.Scanner;

public class C11Q2 {
    static int[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        D = new int[n+1];
        D[1] = 1;
        D[2] = 1;
        for(int i = 3; i <= n; i++) {
            D[i] = D[i-1] + D[i-2];
        }
        System.out.println(D[n]);
    }
}
