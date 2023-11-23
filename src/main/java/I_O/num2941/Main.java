package I_O.num2941;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int length = 0;
        for(int i=word.length()-1; i>=0; i--){
            if(i>0){
                if(word.charAt(i) == 'j'){
                    if(word.charAt((i-1)) == 'l' || word.charAt((i-1)) == 'n'){
                        length++;
                        i--;
                        continue;
                    }
                }
                if(word.charAt(i) == '='){
                    if(word.charAt((i-1)) == 'z'){
                        if (i>1&&word.charAt((i-2)) == 'd'){
                            i -= 2;
                            length++;
                            continue;
                        }
                    }
                    length++;
                    i--;
                    continue;
                }
                if(word.charAt(i) == '-'){
                    length++;
                    i--;
                    continue;
                }
            }
            length++;
        }
        System.out.println(length);
    }
}
