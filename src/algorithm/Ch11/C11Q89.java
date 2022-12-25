package algorithm.Ch11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C11Q89 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[3][n+1];
        boolean all_minus = true;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++) {
            arr[0][i] = Long.parseLong(st.nextToken());
            if(arr[0][i] > 0)
                all_minus = false;
        }
        if(all_minus) {
            long biggest = - 1001L;
            for(int i = 1; i < n+1; i++) {
                if(arr[0][i] > biggest)
                    biggest = arr[0][i];
            }
            System.out.println(biggest);
            return;
        }

        arr[1][0] = 0L;
        arr[2][0] = 0L;

        long answer = -1001L;
        long erased_minus = 0L;
        for(int i = 1; i < n+1; i++) {
            //위배열
            if(arr[1][i-1] < 0) {
                arr[1][i] = arr[0][i];
            }
            else {
                arr[1][i] = arr[1][i-1] + arr[0][i];
            }
            //아래배열
            if(arr[2][i-1] < 0) {
                arr[2][i] = arr[0][i];
                erased_minus = 0L;
            }
            else {
                if(arr[0][i] >= 0) {
                    arr[2][i] = arr[2][i-1] + arr[0][i];
                }
                else {
                    if(erased_minus < arr[0][i]) {
                        arr[2][i] = Math.max(arr[1][i-1], arr[2][i-1] + arr[0][i]);
                    }
                    else {
                        arr[2][i] = arr[1][i-1];
                        erased_minus = arr[0][i];
                    }
                }
            }
            answer = Math.max(answer, arr[2][i]);
        }
        System.out.println(answer);

    }
}
