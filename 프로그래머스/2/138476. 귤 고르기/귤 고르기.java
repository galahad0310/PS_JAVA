import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        
        int r = 0;
        for(int i : list){
            k-=i;
            r++;
            if(k <= 0) break;
        }
        
        return r;
    }
}