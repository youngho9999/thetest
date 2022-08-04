package algorithm.Ch5;

import java.util.Scanner;

public class C5Q8 {

    static int[][] arr;
    static int n;
    static int find_index;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        find_index = sc.nextInt();

        arr = new int[n+1][n+1];
        for(int i = 1; i < n+1; i ++) {
            for(int j = 1; j < n+1; j++) {
                arr[i][j] = i*j;
            }
        }

        //위 반쪽
        int up_half = calc(n-1);
        if(find_index <= up_half) {
            int diagonal = uph();
            //가운데 인경우
            if(find_index == calc(diagonal)) {
                //대각선이 짝수일때
                if(diagonal % 2 == 0) {
                    System.out.println(arr[diagonal/2][diagonal/2 +1]);
                    return;
                }
                //대각선이 홀수 일때
                else {
                    System.out.println(arr[diagonal/2 +1][diagonal/2 +1]);
                    return;
                }
            }
            //가운데 아님
            else {
                int difference = find_index - calc(diagonal-1);
                int temp = (difference -1)/2;
                System.out.println(arr[1+temp][diagonal-temp]);
                return;
            }
        }
        //가운데 줄에 있을 경우
        else if(find_index <= calc(n)) {
            int difference = find_index - calc(n-1);
            int temp = (difference -1)/2;
            System.out.println(arr[1+temp][n-temp]);
            return;
        }
        //아래쪽인 경우
        else {
            int under_diagonal = underh();
            int difference = n*n+1-find_index - calc(under_diagonal-1);
            int temp = (difference -1)/2;
            System.out.println(arr[n-under_diagonal+1-temp][n+temp]);
            return;
        }

    }

    static int uph() {
        int left = 1;
        int right = n-1;
        int m = 0;
        int ans = 0;
        while(left<=right) {
            if(left == right) {
                ans = left;
                break;
            }
            m = (left+right)/2;
            if(find_index <= calc(m)) {
                if(find_index > calc(m-1)) {
                    ans = m;
                    break;
                }
                else {
                    right = m-1;
                    continue;
                }
            }
            else {
                left = m+1;
                continue;
            }
        }
        return ans;
    }

    static int underh() {
        int from_under = n*n+1 - find_index;
        int left = 1;
        int right = n-1;
        int m = 0;
        int ans = 0;
        while(left<=right) {
            if(left == right) {
                ans = left;
                break;
            }
            m = (left+right)/2;
            if(from_under <= calc(m)) {
                if(from_under > calc(m-1)) {
                    ans = m;
                    break;
                }
                else {
                    right = m-1;
                    continue;
                }
            }
            else {
                left = m+1;
                continue;
            }
        }
        return ans;
    }

    static int calc(int num) {
        return num*(num+1)/2;
    }


}
