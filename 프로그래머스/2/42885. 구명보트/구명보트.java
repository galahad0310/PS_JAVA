import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        int i = 0, j = people.length - 1, sum = 0;
        Arrays.sort(people);
        //greedy 전략: 가장 무거운 사람은 무조건 태워야 된다 
        while(i<=j){
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;
            cnt++;
        }
        return cnt;
    }
}