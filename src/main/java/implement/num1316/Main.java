package implement.num1316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Character> history;
    static char preChar;
    static int capacity = 0;
    static boolean valid;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for (int i=0; i<test_case; i++){
            history = new ArrayList<>();
            valid = true;

            String word = br.readLine();
            for(int j=0; j<word.length(); j++){
                if(j==0){
                    preChar = word.charAt(j);
                    continue;
                }
                if(preChar != word.charAt(j)){
                    if(history.contains(word.charAt(j))){
                        valid = false;
                        break;
                    }
                    history.add(preChar);
                    preChar = word.charAt(j);
                }
            }
            if(valid) capacity++;
        }
        System.out.println(capacity);
    }
}
