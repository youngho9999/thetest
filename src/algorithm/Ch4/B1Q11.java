package algorithm.Ch4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1Q11 {

    static ArrayList<Integer>[] A;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        A= new ArrayList[node+1];
        check = new boolean[node+1];
        for(int i = 1; i < node+1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            A[n1].add(n2);
            A[n2].add(n1);
        }



    }
    static void DFS(int i) {
        if(check[i])
            return;
        check[i] = true;
        for(int j : A[i]) {
            if(check[j]==false) {
                DFS(j);
            }
        }

    }

}
