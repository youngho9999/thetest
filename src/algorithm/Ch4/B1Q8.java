package algorithm.Ch4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1Q8 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> Preq = new PriorityQueue<>((o1, o2) -> {

            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2)
                return (abs1>abs2) ? 1 : -1;
            else
                return abs1 - abs2;

        });

        for(int i =0; i < N; i++) {

            int request = Integer.parseInt(br.readLine());
            if(request==0) {
                if(Preq.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(Preq.poll());
            }
            else {
                Preq.add(request);
            }

        }



    }
}
