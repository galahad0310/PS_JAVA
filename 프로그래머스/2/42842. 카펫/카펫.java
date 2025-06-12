import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown+yellow;
        for(int i = 1; i<=Math.sqrt(sum); i++){
            if(sum % i == 0){
                int j = sum/i;
                if(i+j == (brown + 4)/2){
                    return new int[]{Math.max(i, j), Math.min(i, j)};
                }
            }
        }
        return null;
    }
}