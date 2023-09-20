package ect.Num14499;

import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int m;
    static int[] dice = new int[6];
    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rD, cD;
        int move;
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        board = new int[n][m];
        rD=Integer.parseInt(st.nextToken());
        cD=Integer.parseInt(st.nextToken());
        move=Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<move; i++){
            switch(Integer.parseInt(st.nextToken())){
                case 1:
                    if(cD<m-1){
                        int tmp=dice[1];dice[1]=dice[2];dice[2]=dice[0];dice[0]=dice[4];dice[4]=tmp;
                        System.out.println(dice[0]);
                        cD++;
                        compare(board, dice, rD, cD);
                    }
                    break;
                case 2:
                    if(cD>0){
                        int tmp=dice[1];dice[1]=dice[4];dice[4]=dice[0];dice[0]=dice[2];dice[2]=tmp;
                        System.out.println(dice[0]);
                        cD--;
                        compare(board, dice, rD, cD);
                    }
                    break;
                case 3:
                    if(rD>0){
                        int tmp=dice[1];dice[1]=dice[5];dice[5]=dice[0];dice[0]=dice[3];dice[3]=tmp;
                        System.out.println(dice[0]);
                        rD--;
                        compare(board, dice, rD, cD);
                    }
                    break;
                case 4:
                    if(rD<n-1){
                        int tmp=dice[1];dice[1]=dice[3];dice[3]=dice[0];dice[0]=dice[5];dice[5]=tmp;
                        System.out.println(dice[0]);
                        rD++;
                        compare(board, dice, rD, cD);
                    }
                    break;
            }
        }
    }
    public static void compare(int[][] board, int[] dice, int rD, int cD){
        if(board[rD][cD]!=0){
            dice[1]=board[rD][cD];
            board[rD][cD]=0;
        }else{
            board[rD][cD]=dice[1];
        }
    }
}
