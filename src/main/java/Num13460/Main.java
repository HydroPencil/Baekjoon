package Num13460;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int colum = Integer.parseInt(st.nextToken());
        int answer = -1, level = 0, size;
        String[][] board = new String[row][colum];
        for(int i=0; i<row; i++){board[i] = br.readLine().split("");}
        Queue<String[][]> q = new LinkedList<>();
        Queue<Character> qt = new LinkedList<>();
        q.add(board);
        qt.add('f');
        while(answer<0 && level<11){
            size = q.size();
            for(int i=0; i<size; i++){
                String[][] tmp = q.poll();
                char tmpt = qt.poll();
                String[][] tmps;
                if(tmp[0][0].equals("C")){answer = level; break;}
                else {
                    if(tmpt=='f'){
                        tmps = left(tmp);if(tmps[0][0] != "X"){q.add(tmps);qt.add('l');}
                        tmps = right(tmp);if(tmps[0][0] != "X") {q.add(tmps);qt.add('r');}
                        tmps = up(tmp);if(tmps[0][0] != "X") {q.add(tmps);qt.add('u');}
                        tmps = down(tmp);if(tmps[0][0] != "X") {q.add(tmps);qt.add('d');}
                    }
                    else if(tmpt=='r'||tmpt=='l'){
                        tmps = up(tmp);if(tmps[0][0] != "X") {q.add(tmps);qt.add('u');}
                        tmps = down(tmp);if(tmps[0][0] != "X") {q.add(tmps);qt.add('d');}
                    } else {
                        tmps = left(tmp);if(tmps[0][0] != "X"){q.add(tmps);qt.add('l');}
                        tmps = right(tmp);if(tmps[0][0] != "X") {q.add(tmps);qt.add('r');}
                    }
                }
            }
            level++;
        }
        System.out.printf("%d", answer);
    }
    static String[][] left(String[][] board){
        String[][] newB = new String[board.length][board[0].length];
        for(int i=0; i<board.length; i++){newB[i] = board[i].clone();}
        for(int i=0; i<newB.length; i++){
            int wp = -1; boolean goal = false;
            for(int j=0; j< newB[i].length; j++){
                if(newB[i][j].equals("O")) goal=true;
                if(wp ==-1){if(newB[i][j].equals(".")) wp=j;}
                if(newB[i][j].equals("#")){wp = -1; goal =false;}
                if(newB[i][j].equals("R")){
                    if(goal) {newB[0][0] = "C";newB[i][j] = ".";}
                    else{if(wp != -1) {newB[i][wp] = "R"; newB[i][j] = "."; wp++;}}
                }
                if(newB[i][j].equals("B")){
                    if(goal) {newB[0][0] = "X";newB[i][j] = ".";goal=false;}
                    else{if(wp != -1) {newB[i][wp] = "B"; newB[i][j] = "."; wp++;}}
                }
            }
        }
        if(Arrays.deepEquals(board, newB)){newB[0][0] = "X";}
        return newB;
    }
    static String[][] right(String[][] board){
        String[][] newB = new String[board.length][board[0].length];
        for(int i=0; i<board.length; i++){newB[i] = board[i].clone();}

        for(int i=newB.length-1; i>=0; i--){
            int wp = -1; boolean goal = false;
            for(int j=newB[i].length-1; j>=0; j--){
                if(newB[i][j].equals("O")) goal=true;
                if(wp ==-1){if(newB[i][j].equals(".")) wp=j;}
                if(newB[i][j].equals("#")){wp = -1; goal =false;}
                if(newB[i][j].equals("R")){
                    if(goal) {newB[0][0] = "C";newB[i][j] = ".";}
                    else{if(wp != -1) {newB[i][wp] = "R"; newB[i][j] = "."; wp--;}}
                }
                if(newB[i][j].equals("B")){
                    if(goal) {newB[0][0] = "X";newB[i][j] = ".";goal=false;}
                    else{if(wp != -1) {newB[i][wp] = "B"; newB[i][j] = "."; wp--;}}
                }
            }
        }
        if(Arrays.deepEquals(board, newB)){newB[0][0] = "X";}
        return newB;
    }
    static String[][] up(String[][] board){
        String[][] newB = new String[board.length][board[0].length];
        for(int i=0; i<board.length; i++){newB[i] = board[i].clone();}
        for(int i=0; i<newB[0].length; i++){
            int wp = -1; boolean goal = false;
            for(int j=0; j< newB.length; j++){
                if(newB[j][i].equals("O")) goal=true;
                if(wp ==-1){if(newB[j][i].equals(".")) wp=j;}
                if(newB[j][i].equals("#")){wp = -1; goal =false;}
                if(newB[j][i].equals("R")){
                    if(goal) {newB[0][0] = "C";newB[j][i] = ".";}
                    else{if(wp != -1) {newB[wp][i] = "R"; newB[j][i] = "."; wp++;}}
                }
                if(newB[j][i].equals("B")){
                    if(goal) {newB[0][0] = "X";newB[j][i] = ".";goal=false;}
                    else{if(wp != -1){newB[wp][i] = "B"; newB[j][i] = "."; wp++;}}
                }
            }
        }
        if(Arrays.deepEquals(board, newB)){newB[0][0] = "X";}
        return newB;
    }
    static String[][] down(String[][] board){
        String[][] newB = new String[board.length][board[0].length];
        for(int i=0; i<board.length; i++){newB[i] = board[i].clone();}
        for(int i=newB[0].length-1; i>=0; i--){
            int wp = -1; boolean goal = false;
            for(int j=newB.length-1; j>=0; j--){
                if(newB[j][i].equals("O")) goal=true;
                if(wp ==-1){if(newB[j][i].equals(".")) wp=j;}
                if(newB[j][i].equals("#")){wp = -1; goal =false;}
                if(newB[j][i].equals("R")){
                    if(goal) {newB[0][0] = "C";newB[j][i] = ".";}
                    else{if(wp != -1) {newB[wp][i] = "R"; newB[j][i] = "."; wp--;}}
                }
                if(newB[j][i].equals("B")){
                    if(goal) {newB[0][0] = "X";newB[j][i] = ".";goal=false;}
                    else{if(wp != -1){newB[wp][i] = "B"; newB[j][i] = "."; wp--;}}
                }
            }
        }
        if(Arrays.deepEquals(board, newB)){newB[0][0] = "X";}
        return newB;
    }
}
/*
if(newB[j][i].equals("B")){
if(goal) {newB[0][0] = "X";newB[j][i] = ".";goal=false;}
else{if(wp != -1){newB[wp][i] = "B"; newB[j][i] = "."; wp++;}}
} B가 먼저 구멍에 들어갔을 때 R가 들어가도 c가 되지 못하도록 goal을 미리 false로 바꿔둔다

left or right를 하면 다음 시도는 up or down을 하지 않으면 의미가 의미가 없으므로 걸러 줄 수 있는 방법을 찾아본다 -> 성능차이를 만드는 결정적 요소


 */