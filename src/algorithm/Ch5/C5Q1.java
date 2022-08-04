package algorithm.Ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C5Q1 {
    static boolean[] visit;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        visit = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            A[t1].add(t2);
            A[t2].add(t1);

        }
        //입력 완료
        int k = 1;
        int answer = 0;
        for(int i = 1; i <=n; i++) {
             if(!visit[i]) {
                answer++;
                DFS(i);
            }
        }
        System.out.println("정답은? " + answer);


    }

    public static void DFS(int x) {
        if(visit[x]==true)
            return;
        visit[x] = true;
        int count = A[x].size();
        for(int j = 0; j < count; j++) {
            DFS(A[x].get(j));
        }
    }


}
