package algorithm.Ch8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class C8Q54 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //그래프
        ArrayList<Integer>[] init = new ArrayList[n+1];
        //해당 건물 짓는 시간
        int[] buildTime = new int[n+1];
        //진입 차수 배열
        int[] countArr = new int[n+1];
        Arrays.fill(countArr, 0);


        for(int i = 1; i < n+1; i++) {
            init[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int t = Integer.parseInt(st.nextToken());
                if(t == -1)
                    break;
                init[t].add(i);
                countArr[i]++;
            }
        }
        //입력완료

        int[] finalBuild = new int[n+1];



    }
}
