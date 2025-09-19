class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];
        for(int i = 0; i<answer.length; i++){
            int curr = (int)begin + i;
            if(curr == 1){
                answer[i] = 0;
            }else{
                int result = 1;
                for(int j = 2; j <= Math.sqrt(curr); j++){
                    if(curr % j == 0){
                        if(curr / j <= 10_000_000){
                            result = curr / j;
                            break;
                        }else{
                            result = j;
                        }
                    }
                }
                answer[i] = result;
            }
        }
        return answer;
    }
}