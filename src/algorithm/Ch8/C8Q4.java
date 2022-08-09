package algorithm.Ch8;

import java.util.*;

public class C8Q4 {

    static int[] max = new int[3];
//    static int[] nowLevel = new int[3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max[0] = sc.nextInt();
        max[1] = sc.nextInt();
        max[2] = sc.nextInt();
        int[] sample = new int[3];
        sample[0] = 0;
        sample[1] = 0;
        sample[2] = max[2];
        search(sample);


    }
    static int[] pour(int a, int b, int[] nowLevel) {
        int[] tempLevel = new int[3];
        int temp = 0;
        while(temp ==a || temp ==b) {
            temp++;
        }
        tempLevel[temp] = nowLevel[temp];
        if(nowLevel[a]<=max[b]-nowLevel[b]) {
            tempLevel[b] = nowLevel[b] + nowLevel[a];
            tempLevel[a] = 0;
        }
        else {
            tempLevel[a] = nowLevel[a] - max[b] + nowLevel[b];
            tempLevel[b] = max[b];
        }
        return tempLevel;
    }

    static void search(int[] sample) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(sample);
        for(int i = 0; i < 400; i++){
            if(q.isEmpty()) {
                break;
            }
            int[] nowWater = q.poll();
            if(nowWater[0] == 0) {
                if(!set.add(nowWater[2])) {
                    continue;
                }
            }
            for(int k = 0; k < 3; k++) {
                if(nowWater[k] == 0) {
                    continue;
                }
                for(int j = 0; j < 3; j++) {
                    if(k == j)
                        continue;
                    if(nowWater[j] == max[j]) {
                        continue;
                    }
                    int[] newWater = pour(k, j, nowWater);
                    q.add(newWater);
                }
            }
        }
        set.stream().sorted().forEach(System.out::println);
    }


}
