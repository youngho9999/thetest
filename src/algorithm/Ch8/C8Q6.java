package algorithm.Ch8;

import java.util.Scanner;

public class C8Q6 {

    static int[][] arr;
    static int[] linarr;
    static int city;
    static int[] travel;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        city = sc.nextInt();
        int travel_city = sc.nextInt();
        arr = new int[city+1][city+1];
        for(int i = 1; i < city+1; i++) {
            for(int j = 1; j < city+1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        travel = new int[travel_city];
        for(int i = 0; i < travel_city; i++) {
            travel[i] = sc.nextInt();
        }

        linarr = new int[city+1];
        for(int i = 1; i < city+1; i++) {
            linarr[i] = i;
        }

        for(int i = 1; i < city+1; i++) {
            for(int j = 1; j < city+1; j++) {
                if(i<j && arr[i][j] == 1) {
                    linarr[j] = i;
                }
            }
        }
        int temp = find(travel[0]);
        for(int i = 1; i < travel_city; i++) {
            if(temp != find(travel[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    static int find(int x) {
        if(linarr[x] == x)
            return x;
        return linarr[x] = find(linarr[x]);
    }
}
