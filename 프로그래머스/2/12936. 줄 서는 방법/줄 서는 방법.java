import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        int[] answer = new int[n];
        k--; // 0-based 인덱싱

        for (int i = 0; i < n; i++) {
            int index = (int)(k / factorial[n - 1 - i]);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            k %= factorial[n - 1 - i];
        }

        return answer;
    }
}
