package Num1931;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inC = br.readLine();
        int capacity = Integer.parseInt(inC);
        int[][] arr = new int[capacity][];
        for(int i=0; i<capacity; i++){
            String[] in = br.readLine().split(" ");
            arr[i] = new int[]{Integer.parseInt(in[0]), Integer.parseInt(in[1])};
        }
        Arrays.sort(arr, (o1, o2) -> o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0]);
        int answer = 0;
        int tmp = 0;
        for (int[] i: arr){
            if(tmp <= i[0]){
                tmp = i[1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
