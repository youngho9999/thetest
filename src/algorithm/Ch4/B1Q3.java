package algorithm.Ch4;

import java.util.Scanner;
public class B1Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n1];
        int[] sum = new int[n1];
        sum[0] = 0;
        for(int i = 0; i < n1; i++)
        {
            arr[i] = sc.nextInt();
            if(i==0) {
                sum[0] = arr[0];
                continue;
            }
            sum[i] = sum[i-1] + arr[i];
        }
        for(int k=0; k<n1; k++)
        {
            System.out.println(arr[k]);

        }
        for(int k=0; k<n1; k++)
        {

            System.out.println(sum[k]);
        }

        System.out.println("---------------");

        for(int j=0; j<m; j++) {
            int d1 = sc.nextInt();
            int d2 = sc.nextInt();
            int r1 = d1-1;
            int r2 = d2-1;
            if(r1==0)
                System.out.println(sum[r2]);
            else
            System.out.println(sum[r2]-sum[r1-1]);
        }

    }

}
