package algorithm.Ch4;

import java.util.Scanner;
public class B1Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] lt = new int[n];
        for(int i = 0; i < n; i++)
        {
            lt[i] = sc.nextInt();
        }
        int max = 0;
        for(int i = 0; i < n; i++)
        {
            if(max<lt[i])
                max=lt[i];
        }
        for(int i = 0; i < n; i++)
        {
            if(max!=lt[i])
                lt[i] = lt[i]*100/max;
        }
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += lt[i];

        }
        long ans = sum/n;
        System.out.println(ans);

    }
}
