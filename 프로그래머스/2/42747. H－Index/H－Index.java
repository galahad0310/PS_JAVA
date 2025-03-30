import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int idx = 0;
        int answer = 0;
        for(int h = 0; h<citations[citations.length - 1]; h++){
            while(h > citations[idx]){
                idx++;
            }
            int c1 = citations.length - idx;
            int c2 = idx+1;
            
            if(c1 >= h && c2 <= h){
                answer = h;
            }
        }
        return answer;
    }
}