package naksu;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class naksu {
    public static void main(String[] args) {


            int[] intArray = { 1, 2, 3, 4, 5, 6};

            String str = Arrays.stream(intArray)
                    .mapToObj(String::valueOf)
                    .reduce((x, y) -> y + x)
                    .get();

            System.out.println(str);



    }

}