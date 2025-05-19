class Solution {
    public int solution(int[] queue1, int[] queue2) {
        //큐 두개를 합쳐서 4개의 포인터로 돌리는 전략
        int[] mergedQueue = new int[queue1.length + queue2.length];
        long sum1 = 0, sum2 = 0;
        for(int i = 0; i<queue1.length; i++){
            sum1 += mergedQueue[i] = queue1[i];
        }
        
        int idx = 0;
        for(int i = queue1.length; i<mergedQueue.length; i++){
            sum2 += mergedQueue[i] = queue2[idx++];
        }
        
        if((sum1+sum2) % 2 == 1){
            return -1;
        }
        
        long target = (sum1 + sum2) / 2;
        
        int p1 = 0, p2 = queue1.length - 1;
        int p3 = queue1.length, p4 = queue2.length-1;
        
        int moved = 0;
        
        while(moved < 2 * mergedQueue.length){
            if(sum1 < target && sum2 > target){
                p2 = (p2 + 1) % mergedQueue.length;
                p3 = (p3 + 1) % mergedQueue.length;
                sum1 += mergedQueue[p2];
                sum2 -= mergedQueue[p2];
                moved++;
            }else if(sum1 > target && sum2 < target){
                sum1 -= mergedQueue[p1];
                sum2 += mergedQueue[p1];
                p1 = (p1 + 1) % mergedQueue.length;
                p4 = (p4 + 1) % mergedQueue.length;
                
                moved++;
            }else if(sum1 == target && sum2 == target){
                return moved;
            }
        }
        return -1;
    }
}
