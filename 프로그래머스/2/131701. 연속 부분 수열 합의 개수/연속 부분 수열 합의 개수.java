import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] prefixSum = new int[elements.length * 2 + 1];
        prefixSum[0] = 0;
        for(int i = 1; i<prefixSum.length; i++){
            prefixSum[i] = prefixSum[i-1] + elements[i % elements.length]; 
        }
        for(int i = 1; i<=elements.length; i++){
            for(int j = 0; j<elements.length; j++){
                int end = j+i;
                set.add(prefixSum[end] - prefixSum[j]);
            }
        }
        return set.size();
    }
}