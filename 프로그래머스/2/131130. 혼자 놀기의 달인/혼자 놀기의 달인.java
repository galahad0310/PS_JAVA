import java.util.*;
class Solution {
    List<Integer> groupSize = new ArrayList<>();
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        for(int i = 0; i<cards.length; i++){
            if(!visited[i]){
                dfs(cards, i, visited, 0);
            }
        }
        if(groupSize.size() < 2){
            return 0;
        }
        groupSize.sort(Collections.reverseOrder());
        return groupSize.get(0) * groupSize.get(1);
    }
    
    void dfs(int[] cards, int currentIndex, boolean[] visited, int currentSize){
        if(visited[currentIndex]){
            groupSize.add(currentSize);
            return;
        }
        visited[currentIndex] = true;
        dfs(cards, cards[currentIndex] - 1, visited, currentSize+1);
    }
}