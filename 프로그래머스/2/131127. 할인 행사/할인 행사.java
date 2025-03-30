import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<String, Integer>();
        for(int i = 0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        for(int start = 0; start <= discount.length - 10; start++){
            Map<String, Integer> cand = new HashMap<String, Integer>();
            for(int i = start; i < start + 10; i++){
                cand.put(discount[i], cand.getOrDefault(discount[i], 0)+1);
            }
            if(isValid(wantMap, cand)) answer++;
        }
        return answer;
    }
    boolean isValid(Map<String, Integer> wantMap, Map<String, Integer> cand){
        for(String wantKey : wantMap.keySet()){
            if(!wantMap.get(wantKey).equals(cand.getOrDefault(wantKey, 0))){
                return false;
            }
        }
        return true;
    }
}