class Solution {
    public long solution(int n) {
        long i = 1;
        long j = 2;
        long r = 0;
        if(n == 1) return i;
        if(n == 2) return j;
        for(int t = 2; t<n; t++){
            r = (i + j) % 1234567;
            i = j;
            j = r;
        }
        
        return r;
    }
}