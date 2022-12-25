package versatility;

import java.util.Scanner;

public class Permutation {
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nPr");
        System.out.print("전체 숫자 n 을 입력해주세요: ");
        int n = sc.nextInt();
        System.out.print("고를 숫자 r 을 입력해주세요: ");
        int r = sc.nextInt();

        int[] numPool = new int[n];
        for(int i = 0; i < n; i++) {
            numPool[i] = i+1;
        }
        Perm(numPool,r,0);
        System.out.println("");
        System.out.println("순열 경우의 수: " + count);
    }

    static void Perm(int[] permutation, int r, int depth) {
        if(depth == r) {
            printArr(permutation,r);
            count++;
            return;
        }
        for(int i = depth; i < permutation.length; i++) {
            permutation = swap(permutation,depth,i);
            Perm(permutation,r,depth+1);
            permutation = swap(permutation,depth,i);
        }
    }

    static int[] swap(int[] permutation, int a, int b) {
        int temp = permutation[a];
        permutation[a] = permutation[b];
        permutation[b] = temp;
        return permutation;
    }

    static void printArr(int[] arr, int r) {
        System.out.print("[");
        for(int i = 0; i < r-1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print(arr[r-1] + "]");
    }


}
