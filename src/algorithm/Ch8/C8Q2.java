package algorithm.Ch8;

import java.util.*;

public class C8Q2 {

    static int n;
    static int e;
    static List<Integer>[] arr;
    static int[] answer;
    static int tempAnswer;
    static boolean[] visit;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        arr= new List[n+1];
        answer = new int[n+1];
        visit = new boolean[n+1];

        for(int i = 1; i < n+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < e; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            arr[t2].add(t1);
        }
        int max = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i < n+1; i++) {
            tempAnswer = 0;
            DFS(i,0);
            if(tempAnswer > max) {
                q = new LinkedList<>();
                q.add(i);
                max = tempAnswer;
            }
            else if(tempAnswer == max) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            System.out.println(q.poll());
        }


    }
    static void DFS(int nowNode, int depth) {
        int count = 0;
        visit[nowNode] = true;
        for(int i = 0; i < arr[nowNode].size(); i++) {
            int linkedNode = arr[nowNode].get(i);
            if(visit[linkedNode])
                continue;
            else {
                count++;
                DFS(linkedNode, ++depth);
            }
        }
        visit[nowNode] = false;
        if(count == 0) {
            if(depth > tempAnswer) {
                tempAnswer = depth;
            }
        }
    }


}
