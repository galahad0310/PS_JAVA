import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        map.put("red", 0);
        map.put("orange", 1);
        map.put("yellow", 2);
        map.put("green", 3);
        map.put("blue", 4);
        map.put("purple", 5);

        String[] arr = new String[]{"red", "orange", "yellow", "green", "blue", "purple"};
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String[] input = br.readLine().split(" ");
            if(input[0].equals(input[1])){
                System.out.println("E");
            }else{
                int idx = map.get(input[0]);
                if(arr[(idx+5) % 6].equals(input[1]) || arr[(idx + 1) % 6].equals(input[1])){
                    System.out.println("A");
                }else if(arr[(idx + 3) % 6].equals(input[1])){
                    System.out.println("C");
                }else{
                    System.out.println("X");
                }
            }
        }
    }
}