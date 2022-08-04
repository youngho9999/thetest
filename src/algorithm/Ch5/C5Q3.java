package algorithm.Ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C5Q3 {
    static ArrayList<Integer>[] B;
    static boolean[] visited;
    static boolean ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n_p = Integer.parseInt(st.nextToken());
        int n_fr = Integer.parseInt(st.nextToken());

        visited = new boolean[n_p];
        B = new ArrayList[n_p];

        for(int i = 0; i < n_p; i++) {
            B[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < n_fr; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            B[n1].add(n2);
            B[n2].add(n1);
        }
        for(int i = 0; i < n_p; i++) {
            findfive(i,1);

            if(ans == true) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }
    private static void findfive(int a, int depth) {
        if(visited[a])
            return;
        if(depth == 5) {
            ans = true;
            return;
        }
        visited[a] = true;
        for(int j = 0; j < B[a].size(); j++) {
            findfive(B[a].get(j), depth+1);
        }
        visited[a] = false;
        return;
    }
}
