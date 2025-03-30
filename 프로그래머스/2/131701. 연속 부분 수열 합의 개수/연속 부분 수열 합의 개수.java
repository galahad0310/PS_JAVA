import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] prefixSum = new int[elements.length * 2 + 1];
        for(int i = 0; i<prefixSum.length - 1; i++){
            prefixSum[i+1] = prefixSum[i] + elements[i % elements.length];
        }
        for(int i = 1; i<=elements.length; i++){
            for(int j = 0; j<elements.length; j++){
                int start = j;
                int end = j + i;
                set.add(prefixSum[end] - prefixSum[start]);
            }
        }
        return set.size();
    }
}