class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1, right = Integer.MAX_VALUE;
        int optimized_level = right;
        while(left <= right){
            int mid = (right - left) / 2 + left; //OverFlow 방지
            if(clear(diffs, times, limit, mid)){
                optimized_level = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return optimized_level;
    }
    
    public boolean clear(int[] diffs, int[] times, long limit, int level){
        long usedTime = 0;
        for(int i = 0; i<diffs.length; i++){
            int diff = diffs[i];
            int time_cur = times[i];
            if(diff <= level){
                usedTime += time_cur;
            }else{
                usedTime += (diff - level) * (time_cur + times[i-1]) + time_cur;
            }
        }
        if(usedTime <= limit) return true;
        return false;
    }
}