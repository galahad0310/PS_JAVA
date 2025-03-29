import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        // 배열 두 번 이어붙이기
        int[] doubleArr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            doubleArr[i] = elements[i % n];
        }

        // 누적합 계산
        int[] prefixSum = new int[2 * n + 1];
        for (int i = 0; i < 2 * n; i++) {
            prefixSum[i + 1] = prefixSum[i] + doubleArr[i];
        }

        // 부분 수열 길이 i
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int end = start + len;
                int sum = prefixSum[end] - prefixSum[start];
                set.add(sum);
            }
        }

        return set.size();
    }
}
