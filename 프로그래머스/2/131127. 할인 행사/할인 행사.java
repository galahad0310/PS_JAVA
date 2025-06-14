import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<number.length; i++){
            map.put(want[i], number[i]);
        }
        int r = 0;
        for(int i = 0; i<= discount.length - 10; i++){
            Map<String, Integer> map2 = new HashMap<>();
            
            for(int j = i; j<i+10; j++){
                map2.put(discount[j], map2.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean b = true;
            
            for(String key : map.keySet()){
                if(map2.containsKey(key)){
                    if(map2.get(key) < map.get(key)){
                        b = false;
                    }
                }else{
                    b = false;
                }
            }
            
            if(b) r++;
        }
        return r;
    }
}