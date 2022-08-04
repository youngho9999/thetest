package algorithm.Ch6;

import java.util.Scanner;

public class C6Q1 {
    static int numberOfCoin;
    static int targetPrice;
    static int[] arr;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numberOfCoin = sc.nextInt();
        targetPrice = sc.nextInt();
        arr = new int[numberOfCoin];

        for(int i = 0; i < numberOfCoin; i++) {
            arr[i] = sc.nextInt();
        }
        greedy(targetPrice, 0);
        System.out.println(answer);
    }

    static void greedy(int price, int count) {
        if(price == 0) {
            answer = count;
            return;
        }
        int biggestPrice_index = biggest(price);
        int multiplier = checkMultiplier(price, biggestPrice_index);
        int leftPrice = price - (arr[biggestPrice_index]*multiplier);
        count += multiplier;
        greedy(leftPrice, count);
        return;
    }

    static int biggest(int price) {
        int temp = numberOfCoin-1;
        while(arr[temp]>price) {
            temp--;
        }
        return temp;
    }

    static int checkMultiplier(int price, int index) {
        int j = 1;
        while(arr[index]*j<=price) {
            j++;
        }
        return j-1;
    }
}
