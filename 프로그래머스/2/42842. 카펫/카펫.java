class Solution {
    public int[] solution(int brown, int yellow) {
        int plus = (brown+4)/2;
        int mul = brown + yellow;
        int a = 1, b = 1;
        
        for(int i = 1; i<=mul; i++){
            for(int j = 1; j<=mul; j++){
                if(i * j == mul && i+j == plus){
                    return new int[]{Math.max(i, j), Math.min(i,j)};
                }
            }
        }
        
        return null;
    }
}