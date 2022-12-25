package versatility;


import java.util.Scanner;

public class Combination {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nCr");
        System.out.print("전체 숫자 n 을 입력해주세요: ");
        int n = sc.nextInt();
        System.out.print("고를 숫자 r 을 입력해주세요: ");
        int r = sc.nextInt();

        int[] numPool = new int[n];
        for(int i = 0; i < n; i++) {
            numPool[i] = i+1;
        }
        //만약 n이 4면 numPool = {1,2,3,4}

        int[] combination = new int[r];
        //조합한 수를 담을 배열

        Comb(combination,numPool,0,0);
        System.out.println();
        System.out.print("모든 조합 수: " + count);
    }

    static void Comb(int[] combination, int[] numPool, int nowIndex, int numPoolIndex) {
        if(nowIndex == combination.length) {
            printArr(combination);
            count++;
            return;
        }
        for(int i = numPoolIndex; i < numPool.length; i++) {
            combination[nowIndex] = numPool[i];
            Comb(combination,numPool,nowIndex+1,i+1);
        }
    }
    static void printArr(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print(arr[arr.length-1] + "]");
    }
}
