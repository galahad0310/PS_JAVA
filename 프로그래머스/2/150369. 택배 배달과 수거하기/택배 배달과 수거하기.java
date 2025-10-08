class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0, pickup = 0;
        
        for(int i = n-1; i>-1; i--){
            deliver += deliveries[i];
            pickup += pickups[i];
            while(deliver > 0 || pickup > 0){
                answer += (long)(i + 1) * 2; 
                deliver -= cap;
                pickup -= cap;
            }
        }
        
        return answer;
        
    }
}