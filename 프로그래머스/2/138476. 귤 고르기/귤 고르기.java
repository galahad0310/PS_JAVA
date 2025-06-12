import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i : map.keySet()){
            list.add(map.get(i));
        }
        Collections.sort(list);
        
        int cnt = 0;
        for(int i = list.size() - 1; i>-1; i--){
            k -= list.get(i);
            cnt++;
            if(k <= 0) break;
        }
        
        return cnt;
    }
}