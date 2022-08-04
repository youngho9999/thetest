package algorithm.Ch4;

import java.util.Scanner;

public class B1Q9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String x1 = sc.next();
        int[] A = new int[x1.length()];
        for(int i = 0; i < x1.length(); i++) {
            A[i] = Integer.parseInt(x1.substring(i, i + 1));
        }

        for(int i = 1; i < x1.length(); i++) {

            for(int j = 0; j < i; j++) {
                if(A[i-j] < A[i-j-1]) {
                    int temp = A[i-j];
                    A[i-j] = A[i-j-1];
                    A[i-j-1] = temp;
                }
            }

        }

        for(int i = 0; i < x1.length(); i++) {

            System.out.println(A[i]);
        }

    }

}
