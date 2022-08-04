package algorithm.Ch4;

import java.io.IOException;
import java.util.Scanner;

public class B1Q12 {

    public static int[] a;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        mergeSort(0,n-1);
        for(int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

    }

    private static void mergeSort(int l, int r) {
        if(l==r)
            return;
        int pl = l;
        int pr = (l+r)/2 + 1;
        int mid = pr;
        int[] temp = new int[r-l+1];
        mergeSort(pl, pr-1);
        mergeSort(pr, r);
        int j = 0;
        while(pl!=mid && pr != r+1) {
            if(a[pl] < a[pr]) {
                temp[j] = a[pl];
                pl++;
                j++;
            }
            else {
                temp[j] = a[pr];
                pr++;
                j++;
            }
        }
        while(pl==mid && pr!= r+1) {
            temp[j] = a[pr];
            j++;
            pr++;
        }
        while(pl!=mid && pr==r+1) {
            temp[j] = a[pl];
            j++;
            pl++;
        }
        for(int k = l; k < r+1; k++) {
            a[k] = temp[k-l];
        }

    }

}
