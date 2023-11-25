package implement.num1193;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int numerator = 1;
        int denominator = 1;
        boolean direction = true;//true:denominator++, false:numerator++

        for(int i=0; i<count-1; i++){
            if (numerator==1&&direction){
                denominator++;
                direction = !direction;
                continue;
            }
            if (denominator==1&&!direction){
                numerator++;
                direction = !direction;
                continue;
            }
            if(direction){
                denominator++;
                numerator--;
                continue;
            }
            denominator--;
            numerator++;
        }

        System.out.printf("%d/%d",numerator,denominator);
    }
}
