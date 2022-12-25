package algorithm.Ch11;

import java.util.Scanner;

public class C11Q3 {
    static int[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        D = new int[n+1];

        D[1] = 0;
        D[2] = 1;
        D[3] = 1;
        for(int i = 4; i < n+1; i++) {
            D[i] = i;
        }

        dy(n);
        System.out.println(D[n]);

    }

    static int dy(int n) {
        if(n == 1)
            return 0;
        if(D[n] != n)
            return D[n];
        if(n % 3 == 0) {
            return D[n] = Math.min(D[n], dy(n/3) +1);
        }
        else if(n % 2 == 0){
            return D[n] = Math.min(Math.min(D[n], dy(n / 2) + 1), dy(n - 1) + 1);
        }
        else {
            return D[n] = dy(n-1) + 1;
        }

    }
}
