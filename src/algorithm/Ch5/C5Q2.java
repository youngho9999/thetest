package algorithm.Ch5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C5Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int jarisu = sc.nextInt();
        int jar = 1;
        for(int k = 0; k < jarisu-1; k++) {
            jar *= 10;
        }
        if(jarisu ==1) {
            System.out.println(2);
            System.out.println(3);
            System.out.println(5);
            System.out.println(7);
            return;
        }
        findPrime(2,jar);
        findPrime(3,jar);
        findPrime(5,jar);
        findPrime(7,jar);

    }

    static boolean isPrime(int n) {
        if(n == 1)
            return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void findPrime(int n, int jar) {
        int temp = n*10;
        for(int i = 1; i < 6; i++) {
            if(isPrime(temp+2*i-1)) {
                if((temp+2*i-1) > jar) {
                    System.out.println(temp-1+2*i);
                    continue;
                }
                findPrime(temp-1+2*i, jar);
            }
        }
    }
}
