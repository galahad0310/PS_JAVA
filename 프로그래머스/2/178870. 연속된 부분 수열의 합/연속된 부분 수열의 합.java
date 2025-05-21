class Solution {
    public int[] solution(int[] sequence, int k) {
        int l = 0, r = 0, sum = sequence[0];
        int[] answer = new int[]{-1, -1};
        while(l<=r){
            if(sum < k){
                if(r+1 < sequence.length){
                    sum += sequence[++r];
                }else{
                    break;
                }
            }else if(sum > k){
                sum -= sequence[l++];
            }else{
                if(renew(answer, l, r)){
                    answer[0] = l;
                    answer[1] = r;
                }
                sum -= sequence[l++];
            }
        }
        return answer;
    }
    private boolean renew(int[] answer, int l, int r){
        
        if(answer[0] == -1) return true;
        
        int length1 = answer[1] - answer[0] + 1;
        int length2 = r - l + 1;
        if(length2 < length1){
            return true;
        }
        
        if(length2 == length1){
            if(l < answer[0]){
                return true;
            }
        }
        
        return false;
    }
}