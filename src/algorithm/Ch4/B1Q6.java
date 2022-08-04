package algorithm.Ch4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1Q6 {

    private static int the_answer = 0;
    private static char[] dna;
    private static int[] saveACTG;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        String DNAarr = br.readLine();
        dna = DNAarr.toCharArray();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st2.nextToken());
        int C = Integer.parseInt(st2.nextToken());
        int T = Integer.parseInt(st2.nextToken());
        int G = Integer.parseInt(st2.nextToken());
        saveACTG = new int[4];

        saveACTG[0] = check(dna, m, 'A');
        saveACTG[1] = check(dna, m, 'C');
        saveACTG[2] = check(dna, m, 'T');
        saveACTG[3] = check(dna, m, 'G');

        int l = 0;
        int r = m;
        while(r<n+1) {

            verify(A,C,T,G,saveACTG);
            System.out.println("체크용:theanswer" + the_answer);
            System.out.println("체크용l,r" + l +r);
            removal(l);
            l++;
            adder(m);
            r++;

        }
        System.out.println("정답은 바로:" + the_answer);

    }
    private static int check(char[] a, int p, char b) {
        int checkcounter = 0;
        for(int i = 0; i < p; i++) {
            if(a[i]==b)
                checkcounter++;
        }
        return checkcounter;
    }

    private static void verify(int at, int bt, int ct, int dt, int[] saved) {
        if(saved[0]>=at && saved[1]>=bt && saved[2]>=ct && saved[3]>=dt)
            the_answer++;
    }

    private static void removal(int left) {

        switch(dna[left]) {

            case 'A':
                saveACTG[0]--;
                break;
            case 'C':
                saveACTG[1]--;
                break;
            case 'T':
                saveACTG[2]--;
                break;
            case 'G':
                saveACTG[3]--;
                break;
        }
    }

    private static void adder(int right) {

        switch(dna[right]) {

            case 'A':
                saveACTG[0]++;
                break;
            case 'C':
                saveACTG[1]++;
                break;
            case 'T':
                saveACTG[2]++;
                break;
            case 'G':
                saveACTG[3]++;
                break;
        }
    }



}
