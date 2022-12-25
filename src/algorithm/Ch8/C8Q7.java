package algorithm.Ch8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C8Q7 {

    static int n;
    static int m;
    static ArrayList<Integer>[] arr;
    static int[] myArray;
    static int[] answer;
    static Queue<Integer> q;
    static Queue<Integer> answerQ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();

            arr[t1].add(t2);
        }

        answer = new int[n+1];
        myArray = new int[n+1];
        //진입 차수 배열
        for(int i = 1; i < n+1; i++) {
            for(int j = 0; j < arr[i].size(); j++) {
                myArray[arr[i].get(j)]++;
            }
        }
        q = new LinkedList<>();
        answerQ = new LinkedList<>();
        topology();
        answerQ.stream().forEach(System.out::println);

    }

    static void topology() {
        int temp = 1;
        while(myArray[temp] != 0) {
            temp++;
        }
        q.add(temp);
        while(answerQ.size() != n) {
            int x = q.poll();
            answerQ.add(x);
            myArray[x] = -1;

            for(int i = 0; i < arr[x].size(); i++) {
                myArray[arr[x].get(i)]--;
            }

            for(int i = 1; i < n+1; i++) {
                if(myArray[i] == 0) {
                    q.add(i);
                    myArray[i] = -1;
                }
            }
        }

    }
}
