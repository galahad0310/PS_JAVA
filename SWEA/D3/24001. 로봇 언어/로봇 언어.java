import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String input = br.readLine();
            System.out.println(Math.max(simulate(input, 1), simulate(input, -1)));
        }
    }

    static int simulate(String input, int qValue){
        int pos = 0, maxDist = 0;
        
        for(char c : input.toCharArray()){
            if(c == 'R') pos++;
            else if(c == 'L') pos--;
            else pos += qValue;
            
            maxDist = Math.max(maxDist, Math.abs(pos));
        }
        
        return maxDist;
    }
}
