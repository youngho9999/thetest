package algorithm.Ch5;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class C5Q7revised {
    private static int[] data;
    private static int[] findResult;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numberOf_data = sc.nextInt();

        data = new int[numberOf_data];


        for(int i = 0; i < numberOf_data; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);

        int numberOf_find = sc.nextInt();

        int [] findArray = new int[numberOf_find];
        findResult = new int[numberOf_find];


        for(int i = 0; i < numberOf_find; i++) {
            findArray[i] = sc.nextInt();
        }
        //입력완료
        for(int i = 0; i < numberOf_find; i++) {
            findResult[i] = (find(findArray[i], numberOf_data-1)) ? 1 : 0;
        }

        //출력
        for(int i = 0; i < numberOf_find; i++) {
            System.out.println(findResult[i]);
        }

    }

    static boolean find(int target, int end) {
        int l = 0;
        int r = end;
        int m = 0;
        while(l<=r) {
            m = (l+r)/2;
            if(target == data[m]) {
                return true;
            }
            else if(target > data[m]) {
                l = m+1;
            }
            else {
                r = m-1;
            }
        }
        return false;
    }

}
