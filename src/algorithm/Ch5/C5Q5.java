package algorithm.Ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C5Q5 {

    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int m;
    static Queue<int[]> q = new LinkedList<>();
    static int count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String tempString = st.nextToken();
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tempString.substring(j,j+1));
            }
        }
        findPath();
        System.out.println(count);


    }

    static void findPath() {
        int tn = 0;
        int tm = 0;
        int[] temp = {0,0};
        q.add(temp);
        visit[0][0] = true;
        count = 0;
        while(true) {
            int qsize = q.size();
            count++;
            for(int k = 0; k < qsize; k++) {

                temp = q.poll();
                tn = temp[0];
                tm = temp[1];
                if(tn == n-1 && tm == m-1) {
                    return;
                }
                //오른쪽
                if (tm != (m - 1)) {
                    if (checkValid(tn, tm + 1)) {
                        q.add(new int[]{tn, tm + 1});
                        visit[tn][tm + 1] = true;
                    }
                }
                //아래쪽
                if (tn != (n - 1)) {
                    if (checkValid(tn + 1, tm)) {
                        q.add(new int[]{tn + 1, tm});
                        visit[tn + 1][tm] = true;
                    }
                }
                //왼쪽
                if (tm != 0) {
                    if (checkValid(tn, tm - 1)) {
                        q.add(new int[]{tn, tm - 1});
                        visit[tn][tm - 1] = true;
                    }
                }
                //위쪽
                if (tn != 0) {
                    if (checkValid(tn - 1, tm)) {
                        q.add(new int[]{tn - 1, tm});
                        visit[tn - 1][tm] = true;
                    }
                }
            }

        }
    }

    static boolean checkValid(int x, int y) {
        if(arr[x][y] == 1 && visit[x][y] == false)
            return true;
        else
            return false;
    }








}
