class Solution {
    int[][] dungeons;
    boolean[] visited;
    int max;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        dfs(0, k);
        return max;
    }
    
    private void dfs(int depth, int k){
        for(int i = 0; i<dungeons.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(k < dungeons[i][0]){
                    max = Math.max(max, depth);
                }else{
                    dfs(depth+1, k - dungeons[i][1]);
                }
                visited[i] = false;
            }
        }
        max = Math.max(max, depth);
    }
}