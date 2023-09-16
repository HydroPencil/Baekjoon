package Num3190;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        byte size = Byte.parseByte(br.readLine());
        byte appleN = Byte.parseByte(br.readLine());
        short[][] board = new short[size][size];
        board[0][0] = 1;
        for(byte i=0; i<appleN; i++){
            tk = new StringTokenizer(br.readLine());
            board[Integer.parseInt(tk.nextToken())-1][Integer.parseInt(tk.nextToken())-1] = -1;
        }
        byte moveN = Byte.parseByte(br.readLine());
        Queue<Short> moveTime = new LinkedList<>();
        Queue<Byte> moveDirect = new LinkedList<>();
        for(byte i=0; i<moveN; i++){
            tk = new StringTokenizer(br.readLine());
            moveTime.add(Short.parseShort(tk.nextToken()));
            if(tk.nextToken().equals("L")){
                moveDirect.add((byte) -1);
            } else {
                moveDirect.add((byte) 1);
            }
        }
        short direct = 0;
        short headR = 0, headC = 0, snakeSize = 1, time = 0, mTime = 0;
        byte mD = 0;
        mTime = moveTime.poll();
        mD = moveDirect.poll();
        Deque<Byte> dQ = new LinkedList<>();
        while(headR>=0){
            switch(direct%4){
                case 0:
                    dQ.add((byte) 0);
                    headC++;
                    break;
                case 1:
                    dQ.add((byte) 1);
                    headR++;
                    break;
                case 2:
                    dQ.add((byte) 2);
                    headC--;
                    break;
                case 3:
                    dQ.add((byte) 3);
                    headR--;
                    break;
            }
            time++;
            if(headR<0||headR>=size||headC<0||headC>=size){ headR = -1; break; }
            if(board[headR][headC]!=0){
                if(board[headR][headC] == -1){
                    snakeSize++;
                    board[headR][headC] = snakeSize;
                } else {headR = -1;break;}
            } else {
                board[headR][headC] = snakeSize;
                short tmpR = headR, tmpC = headC;
                Iterator<Byte> dlter = dQ.descendingIterator();
                while(board[tmpR][tmpC]>0){
                    switch (dlter.next()){
                        case 0:
                            board[tmpR][--tmpC] -= 1;
                            break;
                        case 1:
                            board[--tmpR][tmpC] -= 1;
                            break;
                        case 2:
                            board[tmpR][++tmpC] -= 1;
                            break;
                        case 3:
                            board[++tmpR][tmpC] -= 1;
                            break;
                    }
                }
            }
            if(time == mTime){
                direct += mD;
                if(direct <0){direct = 3;}
                if(!moveTime.isEmpty()){
                    mTime = moveTime.poll();
                    mD = moveDirect.poll();
                }
            }
        }

        System.out.printf("%d", time);
    }
}

//0 보통 판, -1 사과,  1, 머리 가장 큰 수
/*입력부 완료*/

//0오른, 1아래, 2왼, 3위