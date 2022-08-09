package naksu;

import java.util.Arrays;

class Solution {
    public String solution(int n) {
        int power = check(n);
        if(n == sum(power+1)) {
            String t = "4";
            for(int i = 0; i < power; i++) {
                t += "4";
            }
            return t;
        }

        int rest = n - sum(power);
        int[] arr = new int[power+1];

        for(int i = power; i>=1; i--) {
            arr[i] = rest/(int)Math.pow(3,i);
            rest = rest % (int)Math.pow(3,i);
            if(rest == 0) {
                break;
            }
        }
        arr[0] = rest;
        if(arr[0] == 0) {
            arr[0] = 4;
            int temp = 1;
            while(arr[temp] == 0) {
                arr[temp] = 2;
                temp++;
            }
            arr[temp] -= 1;
        }
        for(int i = 1; i < power+1; i++) {
            switch(arr[i]) {
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 2;
                    break;
                case 2:
                    arr[i] = 4;
                    break;
            }
        }
        String str = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .reduce((x, y) -> y + x)
                .get();

        return str;
    }
    static int sum(int n) {
        return 3*((int)Math.pow(3,n)-1)/2;
    }
    static int check(int n) {
        int i = 0;
        while(n>sum(i)) {
            if(n<=sum(i+1)) {
                break;
            }
            i++;
        }
        return i;
    }
}