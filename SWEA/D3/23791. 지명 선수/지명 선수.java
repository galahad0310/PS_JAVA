import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            char[] result = new char[n];
            Arrays.fill(result, ' ');
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] A = new int[n];

            for(int i = 0; i<n; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] B = new int[n];
            for(int i = 0; i<n; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

            int pointer_a = 0;
            int pointer_b = 0;

            for(int i = 0; i<n; i++){
                if(i%2 == 0){ //A턴
                    while(pointer_a < n){
                        int want = A[pointer_a];
                        if(result[want - 1] == ' '){
                            result[want - 1] = 'A';
                            pointer_a++;
                            break;
                        }else{
                            pointer_a++;
                        }
                    }
                }else{
                    while(pointer_b < n){
                        int want = B[pointer_b];
                        if(result[want - 1] == ' '){
                            result[want - 1] = 'B';
                            pointer_b++;
                            break;
                        }else{
                            pointer_b++;
                        }
                    }
                }
            }

            System.out.println(new String(result));
        }
    }
}