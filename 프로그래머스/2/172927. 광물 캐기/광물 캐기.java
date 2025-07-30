import java.util.*;
class Solution {
    
    class Fragment{
        private int idx;
        private int pirodo;
        private String[] minerals;
        Fragment(int idx, int pirodo, String[] minerals){
            this.idx = idx;
            this.pirodo = pirodo;
            this.minerals = minerals;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        PriorityQueue<Fragment> fragments = splitFragment(minerals, totalPicks);

        int result = 0;
        
        while(!fragments.isEmpty()){
            Fragment object = fragments.poll();
            int p = -1;
            if(picks[0] > 0){
                p = 0;
                picks[0]--;
            }else if(picks[1] > 0){
                p = 1;
                picks[1]--;
            }else if(picks[2] > 0){
                p = 2;
                picks[2]--;
            }
            if(p == -1) break;
            result += work(p, object);    
        }
        
        return result;
    }
    
    public int work(int p, Fragment object){
        if(p == 0) return object.minerals.length;
        
        int diamondCnt = 0, ironCnt = 0;
        for(String s : object.minerals){
            if(s.equals("diamond")) diamondCnt++;
            if(s.equals("iron")) ironCnt++;
        }
        
        if(p == 1) return object.minerals.length - diamondCnt + (diamondCnt * 5);
        
        return object.minerals.length - diamondCnt - ironCnt + (diamondCnt * 25) + (ironCnt * 5);
    
    }
    
    //minerals를 5개씩 나눔(피로도합, 원본배열의 시작 idx 포함)
    public PriorityQueue<Fragment> splitFragment(String[] minerals, int totalPicks){
        PriorityQueue<Fragment> pq = new PriorityQueue<>((p1, p2) ->{
            if(p1.pirodo != p2.pirodo){
                return p2.pirodo - p1.pirodo;
            }else{
                return p1.idx - p2.idx;
            }
        });
            int maxFragments = Math.min(totalPicks, (minerals.length + 4) / 5); // 5개 단위로 나눈 개수 제한

        for(int i = 0; i<maxFragments; i++){
            int s = 5 * i;
            int idx = s;
            List<String> list = new ArrayList<>();
            int pirodo = 0;
            while(s < i*5 + 5 && s < minerals.length){
                String str = minerals[s];
                list.add(str);
                
                if(str.equals("diamond")){
                    pirodo += 25;
                }else if(str.equals("iron")){
                    pirodo += 5;
                }else{
                    pirodo += 1;
                }
                s++;
            }
            pq.add(new Fragment(idx, pirodo, list.toArray(new String[0])));
        }
        
        return pq;
    }
}