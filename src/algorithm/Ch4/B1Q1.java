package algorithm.Ch4;

import java.util.Scanner;

public class B1Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        String n2 = sc.next();

        char[] n3 = n2.toCharArray();
        int sum=0;
        for(int i = 0; i < n1; i++)
        {

            sum += n3[i] - '0';
        }
        System.out.print(sum);
    }

}
