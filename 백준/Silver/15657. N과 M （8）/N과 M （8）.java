
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static int[] arr;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        selected = new int[m];

        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int d, int s){
        if(d == selected.length){
            for(int i : selected){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i = s; i<arr.length; i++){
            selected[d] = arr[i];
            dfs(d+1, i);
        }
    }

}