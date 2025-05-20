class Solution {
    public int[] solution(int[] sequence, int k) {
        int p1 = 0, p2 = 0;
        int sum = sequence[0];
        int[] answer = new int[]{-1, -1};
        
        while (p1 <= p2 && p1 < sequence.length && p2 < sequence.length) {
            if (sum < k) {
                if (p2 + 1 < sequence.length) {
                    sum += sequence[++p2];
                } else {
                    break;
                }
            } else if (sum > k) {
                sum -= sequence[p1++];
            } else {
                if (renew(answer, p1, p2)) {
                    answer[0] = p1;
                    answer[1] = p2;
                }
                sum -= sequence[p1++];
            }
        }
        return answer;
    }
    
    public boolean renew(int[] answer, int p1, int p2) {
        if (answer[0] == -1) return true;
        
        int length1 = answer[1] - answer[0] + 1;
        int length2 = p2 - p1 + 1;
        
        if (length2 < length1) return true;
        if (length2 == length1 && p1 < answer[0]) return true;
        
        return false;
    }
}
