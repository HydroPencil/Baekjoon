package Num12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            System.out.println(Arrays.toString(str));
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i=0; i<n; i++){
            System.out.printf("%d %d %d\n", board[i][0], board[i][1], board[i][2]);
        }
    }
}
