import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(st.nextToken());
            int bSize = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Set<Integer> a = new HashSet<>();
            for(int i = 0; i<aSize; i++){
                a.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            Set<Integer> b = new HashSet<>();
            for(int i = 0; i<bSize; i++){
                b.add(Integer.parseInt(st.nextToken()));
            }

            boolean flag1 = a.containsAll(b);
            boolean flag2 = b.containsAll(a);

            if(flag1 && flag2){
                System.out.println("=");
            }else if(flag2){
                System.out.println("<");
            }else if(flag1){
                System.out.println(">");
            }else{
                System.out.println("?");
            }
        }
    }
}