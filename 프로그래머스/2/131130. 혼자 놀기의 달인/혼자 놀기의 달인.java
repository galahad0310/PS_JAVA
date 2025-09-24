import java.util.*;
class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groupSize = new ArrayList<>();
        
        for(int i = 0; i<cards.length; i++){
            if(!visited[i]){
                int currentGroupSize = 0;
                int currentIndex = i;
                while(!visited[currentIndex]){
                    visited[currentIndex] = true;
                    currentIndex = cards[currentIndex] - 1;
                    currentGroupSize++;
                }
                groupSize.add(currentGroupSize);
            }
        }
        
        if(groupSize.size() < 2) return 0;
        groupSize.sort(Collections.reverseOrder());
        return groupSize.get(0) * groupSize.get(1);
    }
}