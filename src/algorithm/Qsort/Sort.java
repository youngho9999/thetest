package algorithm.Qsort;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {

    static void swap(int[] a, int i1, int i2) {
        int t = a[i1];
        a[i1] = a[i2];
        a[i2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        System.out.printf("a[%d]~a[%d]: {", left, right);
        for(int i = left; i < right; i++) {
            System.out.printf("%d , ", a[i]);
        }
        System.out.printf("%d}\n", a[right]);

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <=pr)
                swap(a, pl++, pr--);
        }while (pl <= pr);

        if(left < pr) quickSort(a, left, pr);
        if(pl < right) quickSort(a, pl, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("퀵 정렬");
        int nx = sc.nextInt();
        int [] x = new int[nx];

        for(int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }
        quickSort(x, 0, nx-1);
        System.out.println("정렬 완료");
        String s = Arrays.toString(x);
        System.out.println(s);
    }
}
