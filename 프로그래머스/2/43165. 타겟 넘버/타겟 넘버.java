class Solution {
    static int[] n;
    static int t;
    static int answer = 0;
    boolean[] op;
    
    public int solution(int[] numbers, int target) {
        op = new boolean[numbers.length];
        n = numbers;
        t = target;
        
        dfs(0);
        return answer;
    }
    
    void dfs(int v){
        if(v == op.length){
            if(cal(op) == t){
                answer++;
            }
            return;
        } 
        op[v] = true;
        dfs(v+1);
        op[v] = false;
        dfs(v+1);
    }
    
    int cal(boolean[] op){
        int s = 0;
        int idx = 0;
        for(boolean b : op){
            if(b){
                s+=n[idx++];
            }else{
                s-=n[idx++];
            }
        }
        return s;
    }
}