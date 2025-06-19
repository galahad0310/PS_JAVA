import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        int time = 0;
        Queue<String> q = new LinkedList<>();
        for(String s : cities){
            s = s.toLowerCase();
            if(q.remove(s)){
                time+=1;
            }else{
                if(q.size() >= cacheSize){
                    q.poll();
                }
                time+=5;
            }
            q.add(s);
        }
        return time;
    }
}