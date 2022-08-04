package algorithm.Ch4;

import java.io.IOException;
import java.util.Scanner;

public class B1Q13 {

    public static int[] a;
    public static int count;
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
        System.out.println("swap 몇번 했게? " + count);

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
                if(pr-(j+l)>0) {
                    for(int x=0; x<(pr-(j+l)); x++) {
                        count++;
                    }
                }
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
