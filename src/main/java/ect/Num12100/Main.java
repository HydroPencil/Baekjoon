package ect.Num12100;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(str[j]);
            }
        }

        List<Integer> ls = List.of(right(board, 1), left(board, 1), up(board, 1), down(board, 1));
        int answer = Collections.max(ls);
        System.out.printf("%d", answer);
    }

    public static int right(int[][] board, int depth){
        int[][] newBoard = new int[board.length][board[0].length];
        for(int i=0; i< board.length; i++){
            newBoard[i] = board[i].clone();
        }

        int max = -1;
        for(int i=0; i<newBoard.length; i++){
            int p = -1;
            for(int j=newBoard.length-1; j>=0; j--){
                if(newBoard[i][j]!=0){
                    if(p == -1) p = j;
                    else {
                        if(newBoard[i][j] == newBoard[i][p]){newBoard[i][j]*=2; newBoard[i][p]=0; p=-1;}
                        else p = j;
                    }
                }
            }
            p = -1;
            for(int j=newBoard.length-1; j>=0; j--){
                if(max<newBoard[i][j]) {max = newBoard[i][j];}
                if(p == -1){
                    if(newBoard[i][j]==0) p=j;
                } else {
                    if(newBoard[i][j]!=0){
                        newBoard[i][p] = newBoard[i][j];
                        newBoard[i][j] = 0;
                        p=p-1;
                    }
                }
            }
        }
        if(Arrays.deepEquals(board, newBoard)){
            return max;
        } else {
            if(depth<5){
                List<Integer> ls = List.of(right(newBoard, depth+1), left(newBoard, depth+1), up(newBoard, depth+1), down(newBoard, depth+1));
                max = Collections.max(ls);
            }
            return max;
        }
    }
    public static int left(int[][] board, int depth){
        int[][] newBoard = new int[board.length][board[0].length];
        for(int i=0; i< board.length; i++){
            newBoard[i] = board[i].clone();
        }

        int max = -1;
        for(int i=0; i<newBoard.length; i++){
            int p = -1;
            for(int j=0; j<newBoard.length; j++){
                if(newBoard[i][j]!=0){
                    if(p == -1) p = j;
                    else {
                        if(newBoard[i][j] == newBoard[i][p]){newBoard[i][j]*=2; newBoard[i][p]=0; p=-1;}
                        else p = j;
                    }
                }
            }
            p = -1;
            for(int j=0; j<newBoard.length; j++){
                if(max<newBoard[i][j]) {max = newBoard[i][j];}
                if(p == -1){
                    if(newBoard[i][j]==0) p=j;
                } else {
                    if(newBoard[i][j]!=0){
                        newBoard[i][p] = newBoard[i][j];
                        newBoard[i][j] = 0;
                        p=p+1;
                    }
                }
            }
        }
        if(Arrays.deepEquals(board, newBoard)){
            return max;
        } else {
            if(depth<5){
                List<Integer> ls = List.of(right(newBoard, depth+1), left(newBoard, depth+1), up(newBoard, depth+1), down(newBoard, depth+1));
                max = Collections.max(ls);
            }
            return max;
        }
    }
    public static int down(int[][] board, int depth){
        int[][] newBoard = new int[board.length][board[0].length];
        for(int i=0; i< board.length; i++){
            newBoard[i] = board[i].clone();
        }

        int max = -1;
        for(int i=0; i<newBoard.length; i++){
            int p = -1;
            for(int j=newBoard.length-1; j>=0; j--){
                if(newBoard[j][i]!=0){
                    if(p == -1) p = j;
                    else {
                        if(newBoard[j][i] == newBoard[p][i]){newBoard[j][i]*=2; newBoard[p][i]=0; p=-1;}
                        else p = j;
                    }
                }
            }
            p = -1;
            for(int j=newBoard.length-1; j>=0; j--){
                if(max<newBoard[j][i]) {max = newBoard[j][i];}
                if(p == -1){
                    if(newBoard[j][i]==0) p=j;
                } else {
                    if(newBoard[j][i]!=0){
                        newBoard[p][i] = newBoard[j][i];
                        newBoard[j][i] = 0;
                        p=p-1;
                    }
                }
            }
        }
        if(Arrays.deepEquals(board, newBoard)){
            return max;
        } else {
            if(depth<5){
                List<Integer> ls = List.of(right(newBoard, depth+1), left(newBoard, depth+1), up(newBoard, depth+1), down(newBoard, depth+1));
                max = Collections.max(ls);
            }
            return max;
        }
    }
    public static int up(int[][] board, int depth){
        int[][] newBoard = new int[board.length][board[0].length];
        for(int i=0; i< board.length; i++){
            newBoard[i] = board[i].clone();
        }

        int max = -1;
        for(int i=0; i<newBoard.length; i++){
            int p = -1;
            for(int j=0; j<newBoard.length; j++){
                if(newBoard[j][i]!=0){
                    if(p == -1) p = j;
                    else {
                        if(newBoard[j][i] == newBoard[p][i]){newBoard[j][i]*=2; newBoard[p][i]=0; p=-1;}
                        else p = j;
                    }
                }
            }
            p = -1;
            for(int j=0; j<newBoard.length; j++){
                if(max<newBoard[j][i]) {max = newBoard[j][i];}
                if(p == -1){
                    if(newBoard[j][i]==0) p=j;
                } else {
                    if(newBoard[j][i]!=0){
                        newBoard[p][i] = newBoard[j][i];
                        newBoard[j][i] = 0;
                        p=p+1;
                    }
                }
            }
        }
        if(Arrays.deepEquals(board, newBoard)){
            return max;
        } else {
            if(depth<5){
                List<Integer> ls = List.of(right(newBoard, depth+1), left(newBoard, depth+1), up(newBoard, depth+1), down(newBoard, depth+1));
                max = Collections.max(ls);
            }
            return max;
        }
    }
}
