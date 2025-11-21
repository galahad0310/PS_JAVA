import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String input = br.readLine();
            int n = input.length();
            int k = Integer.parseInt(br.readLine());
            long sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<k; i++){
                sum += Long.parseLong(st.nextToken());
            }
            int X = (int)(((sum % n) + n) % n);

            if(X != 0){
                input = input.substring(X) + input.substring(0, X);
            }

            System.out.println(input);
        }
    }
}