package algorithm.Ch4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1Q10 {


    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        QuickSorting(A, 0, N-1);
        for(int j = 0; j < N; j++) {
            System.out.println(A[j]);
        }
    }

    public static void swap(int[] A, int n1, int n2) {
        int temp = A[n1];
        A[n1] = A[n2];
        A[n2] = temp;
    }

    public static void QuickSorting(int[] A, int l, int r) {

        int pl= l;
        int pr= r;
        int x = A[(pl+pr)/2];

        do {
            while(A[pl] < x) pl++;
            while(A[pr] > x) pr--;
            if(pl <=pr)
                swap(A, pl++, pr--);
        }while(pl<=pr);

        if(l < pr) QuickSorting(A,l,pr);
        if(pl<r) QuickSorting(A,pl,r);

    }

}
