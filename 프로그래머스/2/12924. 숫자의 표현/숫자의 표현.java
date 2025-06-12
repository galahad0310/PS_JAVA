class Solution {
    public int solution(int n) {
        int i = 1, j = 1, sum = 1, answer = 0;
        
        while(i<=j){
            if(sum < n){
                j++;
                sum+=j;
            }else if(sum > n){
                sum-=i;
                i++;
            }else{
                answer++;
                sum-=i;
                i++;
            }
        }
        
        return answer;
    }
}