package algorithm.Ch8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class C8Q1 {
    static List<Integer>[] graph;

    static int k;
    static boolean[] answerCity;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int city = sc.nextInt();
        int road = sc.nextInt();
        k = sc.nextInt();
        int startCity = sc.nextInt();
        graph = new List[city+1];
        answerCity = new boolean[city+1];
        for(int j = 1; j < city+1; j++) {
            graph[j] = new ArrayList<Integer>();
        }

        for(int i = 0; i < road; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph[n1].add(n2);
        }
        find(startCity, 0);
//        long count = Stream.of(answerCity).filter(i -> true).count();
        int count = 0;
        for(int i = 1; i < city+1; i++) {
            if(answerCity[i])
                count++;
        }
        System.out.println(count);

    }
    static void find(int city, int depth){
        if(depth == k) {
            answerCity[city] = true;
            return;
        }
        for(int i = 0; i < graph[city].size(); i++) {
            find(graph[city].get(i), depth+1);
        }
        return;
    }
}
