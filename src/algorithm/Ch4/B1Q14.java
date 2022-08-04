package algorithm.Ch4;


import java.net.Inet4Address;
import java.util.*;

public class B1Q14 {


    static int count;
    static int[] answer;
    static int[] origin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> line = new ArrayList<>();
        answer = new int[n];
        origin = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            int forAdd = sc.nextInt();
            line.add(forAdd);
            if(forAdd>max)
                max = forAdd;
        }
        int jarisu = 1;
        while(true) {
            max = max/10;
            if(max == 0)
                break;
            jarisu++;
        }

        for(int j = 0; j < jarisu; j++) {

            Queue<Integer> q0 = new LinkedList<Integer>();
            Queue<Integer> q1 = new LinkedList<Integer>();
            Queue<Integer> q2 = new LinkedList<Integer>();
            Queue<Integer> q3 = new LinkedList<Integer>();
            Queue<Integer> q4 = new LinkedList<Integer>();
            Queue<Integer> q5 = new LinkedList<Integer>();
            Queue<Integer> q6 = new LinkedList<Integer>();
            Queue<Integer> q7 = new LinkedList<Integer>();
            Queue<Integer> q8 = new LinkedList<Integer>();
            Queue<Integer> q9 = new LinkedList<Integer>();
            List<Queue> aa = new ArrayList<>();
            aa.add(q0);
            aa.add(q1);
            aa.add(q2);
            aa.add(q3);
            aa.add(q4);
            aa.add(q5);
            aa.add(q6);
            aa.add(q7);
            aa.add(q8);
            aa.add(q9);


            for(int k = 0; k< line.size(); k++) {
                int realT = line.get(k);
                for(int re = 0; re < j; re++) {
                    realT = realT/10;
                }
                switch (realT % 10) {
                    case 0:
                        q0.add(line.get(k));
                        break;
                    case 1:
                        q1.add(line.get(k));
                        break;
                    case 2:
                        q2.add(line.get(k));
                        break;
                    case 3:
                        q3.add(line.get(k));
                        break;
                    case 4:
                        q4.add(line.get(k));
                        break;
                    case 5:
                        q5.add(line.get(k));
                        break;
                    case 6:
                        q6.add(line.get(k));
                        break;
                    case 7:
                        q7.add(line.get(k));
                        break;
                    case 8:
                        q8.add(line.get(k));
                        break;
                    case 9:
                        q9.add(line.get(k));
                        break;
                }
            }

            int temp = 0;
            for(int x = 0; x < 10; x++) {

                while(aa.get(x).size()!=0) {
                    Object t1 = aa.get(x).poll();
                    String t2 = t1.toString();
                    int t3 = Integer.parseInt(t2);
                    line.set(temp, t3);
                    temp++;
                }
            }


        }

        for(int u : line) {
            System.out.println(u);
        }


    }
}
