import java.util.*;
class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        List<List<Integer>> cases = combination(n, 5);
        int result = 0;
        
        for(List<Integer> candidate : cases){
            Set<Integer> hashSet = new HashSet<>(candidate);
            boolean isPossible = true;
            for(int i = 0; i<q.length; i++){
                int[] input = q[i];
                int response = ans[i];
                int cnt = 0;
                //몇개나 맞는지 세는 과정
                for(int j = 0; j<input.length; j++){
                    if(hashSet.contains(input[j])) cnt++;
                }
                
                if(cnt != response){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) result++;
        }
        return result;
    }
    
    List<List<Integer>> combination(int n, int r){
        List<List<Integer>> result = new ArrayList<>();
        combineHelper(n, r, 1, new ArrayList<>(), result);
        return result;
    }
    
    void combineHelper(int n, int r, int start, List<Integer> buffer, List<List<Integer>> result){
        if(r == 0){
            result.add(new ArrayList<>(buffer));
            return;
        }
        for(int i = start; i<=n; i++){
            buffer.add(i);
            combineHelper(n, r-1, i+1, buffer, result);
            buffer.remove(buffer.size() - 1);
        }
    }
}