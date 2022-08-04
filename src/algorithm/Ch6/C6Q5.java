package algorithm.Ch6;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class C6Q5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        StringTokenizer st = new StringTokenizer(a, "+-", true);


        int sum = 0;
        int minus = 0;
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            if(s.equals("-"))
                break;
            if(!s.equals("+")) {
                int temp = Integer.parseInt(s);
                sum += temp;
            }

        }
        while (st.hasMoreTokens()) {
            String s2 = st.nextToken();
            if(!s2.equals("+") && !s2.equals("-")) {
                minus += Integer.parseInt(s2);
            }
        }
        System.out.println(sum-minus);

    }
}
