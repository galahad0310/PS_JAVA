class Solution {
    public int solution(int n) {
        int i = 0, j = 1, k = 0;
        for(int t = 0; t<n-1; t++){
            k = (i+j) % 1234567;
            i = j;
            j = k;
        }
        
        return k;
    }
}