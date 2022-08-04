package algorithm.Ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C5Q6 {

    static int MAX;
    static ArrayList<Edge>[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new ArrayList[N+1];
        visit = new boolean[N+1];
        for(int i = 1; i<=N; i++) {
            arr[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < N; i++) {
            int currentNode = sc.nextInt();
            while(true) {
                int thatNode = sc.nextInt();
                if(thatNode == -1)
                    break;
                int d = sc.nextInt();
                Edge edge = new Edge(thatNode, d);
                arr[currentNode].add(edge);
            }
        }
        //입력완료




    }


    static class Edge {
        int node;
        int distance;

        public int getNode() {
            return node;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static int Big(int x) {
        visit[x] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        int t_max_index = -1;

        while(true) {
            int now = q.poll();
            System.out.println("now=? " +now);
            int t_max = 0;
            int count = 0;

            for(int j = 0; j < arr[now].size(); j++) {

                int tempNode = arr[now].get(j).getNode();
                int tempD = arr[now].get(j).getDistance();
                if(!visit[tempNode]) {
                    if(tempD > t_max) {
                        t_max = tempD;
                        t_max_index = tempNode;
                        count++;
                    }
                }
            }
            if(count == 0) {
                break;
            }
            System.out.println("tmaxindex 보여줘: " +t_max_index);
            visit[t_max_index] = true;
            q.add(t_max_index);
            MAX += t_max;
        }
        return t_max_index;
    }
}
