class Solution {
    int max;
    int[][] dungeons;
    boolean[] v;
    public int solution(int k, int[][] dungeons) {
        v = new boolean[dungeons.length];
        this.dungeons = dungeons;
        dfs(0, k);
        return max;
    }
    
    private void dfs(int d, int k){
        for(int i = 0; i<dungeons.length; i++){
            if(!v[i]){
                v[i] = true;
                if(k < dungeons[i][0]){
                    max = Math.max(d, max);
                }else{
                    dfs(d+1, k - dungeons[i][1]);
                }
                v[i] = false;
            }
        }
        max = Math.max(d, max);
    }
}