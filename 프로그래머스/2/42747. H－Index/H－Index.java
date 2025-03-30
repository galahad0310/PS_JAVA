import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int start = citations[0];
        int end = citations[citations.length - 1];
        int idx = 0;
        int answer = 0;
        for(int h = 0; h<=end; h++){
            while(h > citations[idx]){
                idx++;
            }
            int a1 = citations.length - idx;
            if(a1 >= h){
                answer =  h;
            }
        }
        return answer;
    }
    
}