package ect.Num13458;

import java.util.*;
import java.io.*;
public class Main {
    static int exVenue;
    static int[] capacity;
    static int proctorM;
    static int proctorS;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        exVenue = Integer.parseInt(tk.nextToken());
        capacity = new int[exVenue];
        tk = new StringTokenizer(br.readLine());
        for(int i=0; i<exVenue; i++){capacity[i] = Integer.parseInt(tk.nextToken());}
        tk = new StringTokenizer(br.readLine());
        proctorM = Integer.parseInt(tk.nextToken());
        proctorS = Integer.parseInt(tk.nextToken());
        long answer = exVenue;
        for(int i : capacity){
            i -= proctorM;
            if(i>0){
                answer += i%proctorS>0 ? i/proctorS + 1 : i/proctorS;
            }
        }
        System.out.print(answer);
    }
}
