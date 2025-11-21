import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim()); // 날짜 수
            int[] price = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            long profit = 0; // 이익은 long!
            int maxPrice = 0;

            // 오른쪽(마지막 날)에서 왼쪽(첫날)으로 탐색
            for (int i = N - 1; i >= 0; i--) {
                if (price[i] > maxPrice) {
                    // 앞으로 이 날이 최고가 => 이 날에 판다고 생각
                    maxPrice = price[i];
                } else {
                    // 이 날에는 사고, maxPrice 날에 판다고 가정
                    profit += (maxPrice - price[i]);
                }
            }

            sb.append('#').append(tc).append(' ').append(profit).append('\n');
        }

        System.out.print(sb.toString());
    }
}
