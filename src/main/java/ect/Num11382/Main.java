package ect.Num11382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N = br.readLine().split(" ");
        System.out.printf("%d", Long.parseLong(N[0])+Long.parseLong(N[1])+Long.parseLong(N[2]));
    }
}
