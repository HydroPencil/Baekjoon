package Num1697;

import java.io.*;
import java.util.*;

public class Main {
    final public static int MAX_POINT = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int su = Integer.parseInt(in[0]), bro = Integer.parseInt(in[1]), level = 0, size;
        if (su == bro) {System.out.printf("%d", level); return;}
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[MAX_POINT];
        q.add(su);
        visited[su] = true;
        while (!visited[bro]) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                int current = q.poll();
                visited[current] = true;
                if (current == bro) {
                    System.out.printf("%d", level);
                    return;
                }
                if (current * 2 <= 100000 && !visited[current * 2]) {
                    q.add(current * 2);
                }
                if (current - 1 >= 0 && !visited[current - 1]) {
                    q.add(current - 1);
                }
                if (current + 1 <= 100000 && !visited[current + 1]) {
                    q.add(current + 1);
                }
            }
            level++;
        }
        br.close();
    }
}




//class Node {
//    int num, level;
//    Node(int num, int level){this.num = num; this.level = level;}
//    public int getNum() {return num;}
//    public int getLevel() {return level;}
//}
//
//public class Main {
//    final public static int MAX_POINT = 100001;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] in = br.readLine().split(" ");
//        int su = Integer.parseInt(in[0]), bro = Integer.parseInt(in[1]), level = 0;
//        Queue<Node> q = new LinkedList<>();
//        boolean visited[] = new boolean[MAX_POINT]; Arrays.fill(visited, false);
//
//        if(su == bro){
//            System.out.printf("%d", level);
//        } else {
//            q.add(new Node(su, level)); visited[su] = true;
//            while (visited[bro] == false) {
//                Node current = q.poll();
//                if(current.getNum() == bro){level = current.getLevel(); break;}
//                buildNode(current.getNum(), q, visited, current.getLevel());
//                visited[current.getNum()] = true;
//            }
//            System.out.printf("%d", level);
//        }
//        br.close();
//    }
//    public static void buildNode(int source, Queue<Node> q, boolean[] visited, int level) {
//        if(source*2 >= 0 && source*2 <= 100000){if(visited[source*2] == false) {q.add(new Node(source*2, level+1));}}
//        if(source-1 >= 0 && source-1 <= 100000){if(visited[source-1] == false) {q.add(new Node(source-1, level+1));}}
//        if(source+1 >= 0 && source+1 <= 100000){if(visited[source+1] == false) {q.add(new Node(source+1, level+1));}}
//    }
//}


//    public static int mino (int in, int bro, int level, int max){
//        int reIn = in-1;
//        int relevel = level+1;
//        if(reIn == bro){ return relevel;} else if(reIn < 0 || reIn >= bro*2 || relevel>max){return max;}
//        else {
//            return Math.min(mino(reIn, bro, relevel, max),twi(reIn, bro, relevel, max));
//        }
//
//    }
//    public static int plus (int in, int bro, int level, int max){
//        int reIn = in+1;
//        int relevel = level+1;
//        if(reIn == bro){ return relevel;} else if(reIn < 0 || reIn >= bro*2 || relevel>max){return max;}
//        else {
//            return Math.min(plus(reIn, bro, relevel, max),twi(reIn, bro, relevel, max));
//        }
//    }
//    public static int twi(int in, int bro, int level, int max) {
//        int reIn = 2*in;
//        int relevel = level+1;
//        if(reIn == bro){ return relevel;} else if(reIn < 0 || reIn >= bro*2 || relevel>max){return max;}
//        else {
//            return Math.min(Math.min(mino(reIn, bro, relevel, max),plus(reIn, bro, relevel, max)),twi(reIn, bro, relevel, max));
//        }
//    } dfs