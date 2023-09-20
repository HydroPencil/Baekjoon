package ect.Num14501;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] date;
    static int[] pay;
    static int sum=0; //상담을 한번도 안했을 경우를 대비해서 MIN_VALUE대신 0을 기입해야한다.
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        date=new int[N];
        pay=new int[N];
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            date[i]=Integer.parseInt(st.nextToken());
            pay[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
            calc(i, pay[i]);
        }
        System.out.print(sum);
    }
    static void calc(int day, int tmp){
        if(day+date[day]<=N){
            for(int i=day+date[day]; i<N; i++){
                calc(i, tmp+pay[i]);
            }
            sum=Math.max(sum, tmp);
        }
    }
}
