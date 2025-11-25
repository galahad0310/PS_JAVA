import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int num = 1;
        while(t-- > 0) {
            String s = br.readLine();
            String reverse = new StringBuilder(s).reverse().toString();
            int output = s.equals(reverse) ? 1 : 0;
            System.out.printf("#%d %d\n", num++, output);
        }
    }
}