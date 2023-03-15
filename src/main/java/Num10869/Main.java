package Num10869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]), B = Integer.parseInt(s[1]);
        System.out.printf("%d\n%d\n%d\n%d\n%d",A+B,A-B,A*B,A/B,A%B);
    }
}