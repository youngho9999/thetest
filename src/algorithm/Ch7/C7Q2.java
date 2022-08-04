package algorithm.Ch7;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C7Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextInt();
        long max = sc.nextInt();

        Boolean[] numbers = new Boolean[(int) (max + 1)];
        Arrays.fill(numbers, true);


        for(long i = 2L; i <= Math.sqrt(max); i++) {
            long i2 = i*i;
            for(long j = i2; j <= max; j = j + i2) {
                numbers[(int) j] = false;
            }
        }

        long count = Arrays.stream(numbers,(int) min, (int) max).filter(i -> i == true).count();
        System.out.println(count);


    }
}
