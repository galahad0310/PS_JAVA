import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] arr : clothes){
            map.put(arr[1], map.getOrDefault(arr[1], 0)+1);
        }
        
        int v = 1;
        
        for(int i : map.values()){
            v*=(i+1);
        }
        
        return --v;
    }
}