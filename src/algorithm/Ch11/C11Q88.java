package algorithm.Ch11;

import java.util.Scanner;

public class C11Q88 {

    static long mod = 1_000_000_000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1) {
            System.out.println(9);
            return;
        }

        long[][] arr = new long[10][101];
        arr[0][2] = 1L;
        arr[9][2] = 1L;
        for(int i=1 ; i<9; i++) {
            arr[i][2] = 2L;
        }
        for(int i = 3; i <= n; i++) {
            arr[0][i] = arr[1][i-1] % mod;
            arr[9][i] = arr[8][i-1] % mod;
            for(int j = 1; j < 9; j++) {
                arr[j][i] = (arr[j-1][i-1] + arr[j+1][i-1]) % mod;
            }
        }
        long answer = 0L;
        for(int i = 1; i < 10; i++) {
            answer += arr[i][n];
        }
        System.out.println(answer % mod);

    }
}
