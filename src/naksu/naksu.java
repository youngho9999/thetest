package naksu;


import java.util.stream.IntStream;
import java.util.stream.Stream;

public class naksu {
    public static void main(String[] args) {

        Boolean[] arr= {true, false, false, false};
        long count = Stream.of(arr).filter((i) -> i).count();
        System.out.println(count);
    }

}