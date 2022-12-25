package algorithm.Ch11;

import java.util.Scanner;

public class C11Q4 {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[2][n+1];

        for(int i = 1; i < n+1; i++) {
            arr[0][i] = sc.nextInt();
            arr[1][i] = sc.nextInt();
        }

        for(int i = 1; i < n+1; i++) {
            if(arr[0][i] > n-i+1) {
                arr[1][i] = 0;
            }
        }
        int[] D = new int[n+2];
        D[n] = arr[1][n];
        D[n+1] = 0;
        for(int i = n-1; i > 0; i--) {
            if(arr[1][i] == 0) {
                D[i] = 0;
                continue;
            }
            D[i] = Math.max(D[i+1], arr[1][i] + D[i+arr[0][i]]);
        }
        System.out.println(D[1]);
    }
}
