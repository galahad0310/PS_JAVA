import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            int max = 0;
            for(int i = 0; i<6; i++){
                int n = Integer.parseInt(st.nextToken());
                sum += n;
                max = Math.max(max, n);
            }
            
            int candidate = max + 1;
            while ((sum + candidate) % 7 != 0) {
                candidate++;
            }

            System.out.println(candidate);
        }
    }
}