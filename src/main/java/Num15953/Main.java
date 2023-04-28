package Num15953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cy = br.readLine();
        for(int i = 0; i < Integer.parseInt(cy); i++){
            int money = 0;
            String[]  rank = br.readLine().split(" ");
            money = reword(Integer.parseInt(rank[0]), Integer.parseInt(rank[1]));
            System.out.printf("%d\n",money);
        }
        System.exit(0);
    }

    public static int reword(int rank1, int rank2) {
        int money = 0;
        if(rank1 != 0) {
            if(rank1 <= 1){
                money += 5000000;
            } else if(rank1 <= 3){
                money += 3000000;
            } else if(rank1 <= 6){
                money += 2000000;
            } else if(rank1 <= 10){
                money += 500000;
            } else if(rank1 <= 15){
                money += 300000;
            } else if(rank1 <= 21){
                money += 100000;
            }
        }
        if(rank2 != 0) {
            if(rank2 <= 1){
                money += 5120000;
            } else if(rank2 <= 3){
                money += 2560000;
            } else if(rank2 <= 7){
                money += 1280000;
            } else if(rank2 <= 15){
                money += 640000;
            } else if(rank2 <= 31){
                money += 320000;
            }
        }
        return money;
    }
}

