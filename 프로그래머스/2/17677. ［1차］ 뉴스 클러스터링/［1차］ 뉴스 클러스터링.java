import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> m1 = getMultipleSet(str1.toLowerCase());
        Map<String, Integer> m2 = getMultipleSet(str2.toLowerCase());
        if(m1.size() == 0 && m2.size() == 0){
            return 65536;
        }
        int child = getChild(m1, m2);
        int parent = getParent(m1, m2);
        
        return calculate(child, parent);
    }
    
    int calculate(int child, int parent){
        double r = 1.0*child/parent;
        r *= 65536;
        return (int)r;
    }
    
    int getParent(Map<String, Integer> m1, Map<String, Integer> m2){
        int cnt = 0;
        Map<String, Integer> m3 = new HashMap<>();
        for(String key : m1.keySet()){
            if(m2.containsKey(key)){
                m3.put(key, Math.max(m1.get(key), m2.get(key)));
            }else{
                m3.put(key, m1.get(key));
            }
        }
        for(String key : m2.keySet()){
            if(!m1.containsKey(key)){
                m3.put(key, m2.get(key));
            }
        }
        for(int v : m3.values()){
            cnt+=v;
        }
        return cnt;
    }
    
    int getChild(Map<String, Integer> m1, Map<String, Integer> m2){
        int cnt = 0;
        for(String key : m1.keySet()){
            if(m2.containsKey(key)){
                cnt += Math.min(m1.get(key), m2.get(key));
            }
        }
        return cnt;
    }
    
    Map<String, Integer> getMultipleSet(String str){
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<str.length()-1; i++){
            String s = str.substring(i, i+2);
            boolean b = true;
            for(char c : s.toCharArray()){
                if(!(c>='a'&& c<='z')){
                    b = false;
                }
            }
            if(b){
                map.put(s, map.getOrDefault(s, 0)+1);
            }
        }
        return map;
    }
    
}