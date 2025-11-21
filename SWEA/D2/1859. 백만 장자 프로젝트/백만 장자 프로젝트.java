import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{

    static class Product{
        int price;
        int idx;
        Product(int price, int idx){
            this.price = price;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long profit = 0;

            for(int i = n-1; i>-1; i--){
                if(arr[i] > max){
                    max = arr[i];
                }else{
                    profit += (max - arr[i]);
                }
            }

            System.out.printf("#%d %d\n", tc+1, profit);
        }
    }
}