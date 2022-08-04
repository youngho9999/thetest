package algorithm.Ch4;

import java.util.Scanner;

public class B1Q4 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n2 = n/2 + 5;
        int[] a = new int[n2];
        for(int i = 0; i < n2; i++)
        {
            a[i] = i;
        }

        int l = 1;
        int r = 2;
        int sum = 1;
        int ans = 0;
        while(true) {

            for(int j = l; j < (n2-3); j++) {
                sum += a[r];
                if(sum == n) {
                    ans++;
                    break;
                }
                if(sum>n) {
                    break;
                }
                r++;
            }

            l++;
            sum = a[l];
            r=l+1;
            if(l==(n2-2))
                break;
        }
        System.out.println(ans+1);
    }
}
