package algorithm.Ch11;

import java.util.Scanner;

public class C11Q87 {
    static long mod = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] D = new long [1001];
        D[1] = 1L;
        D[2] = 2L;
        for(int i = 3; i < n+1; i++) {
            D[i] = (D[i-1] + D[i-2]) % mod;
        }
        System.out.println(D[n]);
        sc.close();
    }
}
