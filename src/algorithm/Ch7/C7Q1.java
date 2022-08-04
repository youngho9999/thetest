package algorithm.Ch7;

import java.util.Arrays;
import java.util.Scanner;


public class C7Q1 {
    static Boolean[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        arr = new Boolean[end+1];
        Arrays.fill(arr, true);
        for(int i = 2; i < end/2; i++) {
            for(int j = i+1; j < end+1; j++) {
                if(j % i == 0)
                    arr[j] = false;
            }
        }
        for(int k = start; k < end+1; k++) {
            if(arr[k] == true)
                System.out.println(k);
        }

    }
}
