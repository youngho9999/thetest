package algorithm.Ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C5Q4 {

    static ArrayList<Integer>[] adfs;
    static boolean[] dinv;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());


        dinv = new boolean[n];
        adfs = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adfs[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            adfs[t1].add(t2);
            adfs[t2].add(t1);
        }

        dfs2(startNode);
        System.out.println(" ");
        dinv = new boolean[n];
        bfs(startNode, n);

    }

    static void dfs2(int x) {
        dinv[x] = true;
        System.out.print(x + " ");
        for(int j : adfs[x]) {
            if(!dinv[j]) {
                dfs2(j);
            }
        }
    }

    static void bfs(int y, int n) {

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(y);

        while(!q.isEmpty()){
            int temp = q.poll();
            dinv[temp] = true;
            System.out.print(temp + " ");
            for(int j : adfs[temp]) {
                if(!dinv[j]) {
                    q.add(j);
                    dinv[j] = true;
                }
            }


        }

    }

}
