package Num15954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        String[] intsIn = br.readLine().split(" ");
        int[] ints = new int[intsIn.length];
        for(int i=0; i<intsIn.length; i++){
            ints[i] = Integer.parseInt(intsIn[i]);
        }
        double result = Double.MAX_VALUE;
        int N = Integer.parseInt(in[0]); int K = Integer.parseInt(in[1]);
        for(int i = K; i<=N; i++){
            for(int j = 0; j<=N - i; j++){
                double m = 0;
                double a = 0;
                double sum = 0;
                for(int k = j; k < j+i; k++){
                    sum += ints[k];
                }
                m = sum/i;
                for(int k = j; k < j+i; k++){
                    a += Math.pow(ints[k]-m,2);
                }
                a /= i;
                if(Math.sqrt(a) < result){
                    result = Math.sqrt(a);
                }
            }
        }
        System.out.printf("%.11f",result);
        br.close();
    }
}
