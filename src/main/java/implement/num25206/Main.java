package implement.num25206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, Double> gradePoint = new HashMap<>(){{
        put("A+", 4.5);
        put("A0", 4.0);
        put("B+", 3.5);
        put("B0", 3.0);
        put("C+", 2.5);
        put("C0", 2.0);
        put("D+", 1.5);
        put("D0", 1.0);
        put("F", 0.0);
    }};
    final static int CLASS_NUMBER = 20;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0.0;
        double devide = 0;
        for(int i=0; i<CLASS_NUMBER; i++){
            String[] imf = br.readLine().split(" ");
            if(imf[2].equals("P")) continue;
            double tmpD = Double.parseDouble(imf[1]);
            sum += tmpD * gradePoint.get(imf[2]);
            devide += tmpD;
        }
        System.out.printf("%.6f", sum/devide);
    }
}