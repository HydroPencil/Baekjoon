package Num14500;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] board;
    static boolean[][] visited;
    static int[] r={-1,1,0,0};
    static int[] c={0,0,-1,1};
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j]=true;
                search(board[i][j],i,j,1);
                visited[i][j]=false;
            }
        }

        System.out.print(answer);
    }
    static void search(int sum, int row, int col, int depth){
        if(depth==4){
            answer=Math.max(answer,sum);
            return;
        }
        for (int i=0; i<4; i++){
            if(row+r[i]<0||row+r[i]>=n||col+c[i]<0||col+c[i]>=m){continue;}

            if(!visited[row+r[i]][col+c[i]]){
                if(depth==2){
                    visited[row+r[i]][col+c[i]]=true;
                    search(sum+board[row+r[i]][col+c[i]], row, col, depth+1);
                    visited[row+r[i]][col+c[i]]=false;
                }
                visited[row+r[i]][col+c[i]]=true;
                search(sum+board[row+r[i]][col+c[i]], row+r[i], col+c[i], depth+1);
                visited[row+r[i]][col+c[i]]=false;
            }
        }
    }
}
