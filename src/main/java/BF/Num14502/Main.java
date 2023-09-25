package BF.Num14502;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static int[] r={-1,1,0,0};
    static int[] c={0,0,-1,1};
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;

        System.out.print(max);
    }
    static void calc(int depth){
        if(depth==3){
            gasDiffuse();
            return;
        } else {
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(board[i][j]==0){
                        board[i][j]=1;
                        calc(depth+1);
                        board[i][j]=0;
                    }
                }
            }
        }
    }
    static void gasDiffuse(){
        int[][] copyBoard = new int[N][M];
        for(int i=0; i<N; i++){
            copyBoard[i] = Arrays.copyOfRange(board[i],0,M);
        }

//        for(int i=0; i<4; i++){
//            int nowR=row+r[i], nowC=col+c[i];
//            if(nowR<0||nowR>=N||nowC<0||nowC>=M){continue;}
//            else{
//                if(board[nowR][nowC]==0){
//                    board[nowR][nowC]=2;
//                    gasR.add(nowR);gasC.add(nowC);
//                    gasDiffuse(nowR, nowC, ++count);
//                    board[nowR][nowC]=0;
//                }
//            }
//        }
    }
}