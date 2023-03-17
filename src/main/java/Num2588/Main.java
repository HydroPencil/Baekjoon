package Num2588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A=Integer.parseInt(br.readLine()), B=Integer.parseInt(br.readLine());
        System.out.printf("%d\n%d\n%d\n%d", A*(B%10), A*((B/10)%10), A*(B/100), A*B);
    }
}
