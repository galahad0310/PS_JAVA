import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        int pivot = -1;
        for(int i = 0; i<speeds.length; i++){
            int v = (int)Math.ceil(1.0 * (100 - progresses[i]) / speeds[i]);
            if(pivot == -1){
                pivot = v;
                cnt++;
            }else{
                if(pivot >= v){
                    cnt++;
                }else{
                    list.add(cnt);
                    cnt = 1;
                    pivot = v;
                }
            }
        }
        if(cnt >= 0) list.add(cnt);
        return list.stream().mapToInt(i->i).toArray();
    }
}