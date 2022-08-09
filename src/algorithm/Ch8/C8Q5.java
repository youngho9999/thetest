package algorithm.Ch8;


import java.util.Scanner;

public class C8Q5 {
static int[] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int q = sc.nextInt();

        graph= new int[num+1];
        for(int i = 0; i < num+1; i++) {
            graph[i] = i;
        }

        for(int i = 0; i < q; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            int t3 = sc.nextInt();

            if(t1 == 0) {
                union(t2,t3);
            }
            else {
                 if(find(t2)!=find(t3)) {
                     System.out.println("No");
                 }
                 else {
                     System.out.println("YES");
                 }

            }
        }
    }

    static void union(int origin, int change) {
        int headOfChange = findRoot(change);
        graph[headOfChange] = graph[origin];
    }

    static int find(int t) {
        if(graph[t] == t) {
            return t;
        }
        int temp = findRoot(graph[t]);
        graph[t] = temp;
        return temp;
    }

    static int findRoot(int t) {
        if(graph[t] == t) {
            return t;
        }
        return findRoot(graph[t]);
    }
}
