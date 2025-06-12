import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        int i = 0, j = people.length - 1, sum = 0;
        Arrays.sort(people);
        while(i<=j){
            sum = people[i] + people[j];
            if(sum > limit){
                j--;
                cnt++;
            }else{
                i++;
                j--;
                cnt++;
            }
        }
        return cnt;
    }
}