package algorithm.Ch4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1Q5 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());

        }
        Arrays.sort(A);
        int verify = 2;
        if(N<3) {
            System.out.println(count);
        }

        else {
            while (verify < N) {
                int l = 0;
                int r = verify-1;
                while(l<r) {
                    long sum = A[l] + A[r];
                    if(sum == A[verify]) {
                        count++;
                        break;
                    }
                    else if (sum < A[verify]) {
                        l++;
                    }
                    else if (sum > A[verify]) {
                        r++;
                    }
                }
                verify++;

            }
            System.out.println(count);
        }
    }
}
