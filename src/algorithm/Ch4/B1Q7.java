package algorithm.Ch4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1Q7 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int[] ansarr = new int[N];
        Stack<Integer> myStack = new Stack<>();


        int j = 0;
        while(j<N) {

            if(myStack.empty() == true)
                myStack.push(j);
            else if(arr1[j] <= arr1[myStack.peek()])
                myStack.push(j);
            else {
                do {
                    int k = myStack.peek();
                    ansarr[k] = arr1[j];
                    myStack.pop();
                } while(myStack.empty() == false && arr1[j] > arr1[myStack.peek()]);
                myStack.push(j);
            }
            j++;
        }
        int remain = myStack.size();
        while(remain!=0){
            int temp = myStack.peek();
            ansarr[temp] = -1;
            myStack.pop();
            remain--;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            bw.write(ansarr[i] + " ");
            }
        bw.write("\n");
        bw.flush();
        }

    }




