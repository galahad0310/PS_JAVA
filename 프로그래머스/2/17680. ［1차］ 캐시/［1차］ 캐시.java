import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        LRU<String, Boolean> cache = new LRU<String, Boolean>(cacheSize);
        int time = 0;
        for(String s : cities){
            String key = s.toLowerCase();
            if(cache.containsKey(key)){
                time+=1;
            }else{
                time+=5;
            }
            cache.put(key, true);
        }
        return time;
    }
    
    class LRU<K, V> extends LinkedHashMap<K, V>{
        private final int capacity;
        
        public LRU(int capacity){
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
            return size() > capacity;
        }
        
    }
}