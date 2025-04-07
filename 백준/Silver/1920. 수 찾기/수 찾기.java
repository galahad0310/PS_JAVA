import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            int x = Integer.parseInt(st.nextToken());
            int k = Arrays.binarySearch(arr, x);
            if(k > -1){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}