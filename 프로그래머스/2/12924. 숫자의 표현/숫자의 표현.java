class Solution {
    public int solution(int n) {
        int[] s = new int[n+1];
        
        for(int i = 1; i<n+1; i++){
            s[i] = s[i-1] + i;
        }
        
        int i = 0, j = 1, answer = 0;
        
        while(i<j){
            int sum = s[j] - s[i];
            if(sum < n){
                j++;        
            }else if(sum > n){
                i++;
            }else{
                answer++;
                i++;
            }
        }
        return answer;
    }
}