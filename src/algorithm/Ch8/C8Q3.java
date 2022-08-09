package algorithm.Ch8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C8Q3 {
    static int n;
    static int e;
    static List<Integer>[] arr;

    static int[] visit;
    static boolean answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        arr = new List[n + 1];
        visit = new int[n+1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < e; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            arr[t2].add(t1);
            arr[t1].add(t2);
        }
        DFS(1,1);
        if(answer) {
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
        }
    }
    static void DFS(int nowNode, int color) {
        if(answer) {
            return;
        }
        visit[nowNode] = color;
        for(int i = 0; i < arr[nowNode].size(); i++) {
            int linkedNode = arr[nowNode].get(i);
            if(visit[linkedNode] == color) {
                answer = true;
                return;
            }
            else if(visit[linkedNode] == 0){
                DFS(linkedNode, -color);
            }
        }
    }


}
