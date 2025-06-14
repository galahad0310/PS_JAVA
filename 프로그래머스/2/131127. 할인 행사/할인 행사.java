import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        int r = 0;
        
        for(int i = 0; i<discount.length - 9; i++){
            Map<String, Integer> map = new HashMap<>();

            for(int j = i; j<i+10; j++){
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean isPossible = true;
            
            for(String key : wantMap.keySet()){
                if(wantMap.get(key) != map.get(key)){
                    isPossible = false;
                    break;
                }
            }
            
            if(isPossible) r++;
        }
        
        return r;
    }
}