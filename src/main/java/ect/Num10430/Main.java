package ect.Num10430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int A=Integer.parseInt(str[0]), B=Integer.parseInt(str[1]), C=Integer.parseInt(str[2]);
        System.out.printf("%d\n%d\n%d\n%d", (A+B)%C,((A%C) + (B%C))%C,(A*B)%C,((A%C)*(B%C))%C);
    }
}