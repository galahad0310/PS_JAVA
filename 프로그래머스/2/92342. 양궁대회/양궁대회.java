class Solution {
    int[] answer = {-1};
    int maxDiff = -1;
    public int[] solution(int n, int[] info) {
        dfs(info, new int[11], n, 0);
        return answer;
    }
    
    //라이언이 화살을 쏘는 모든 경우의 수
    private void dfs(int[] a_info, int[] r_info, int n, int depth){
        //도출된 경우의 수를 갱신
        if(depth == 11){
            if(n > 0){
                r_info[10] += n;
            }
            calculate(a_info, r_info);
            if(n > 0){
                r_info[10] = 0;
            }
            return;
        }
        //이 depth에서 화살을 쏘는 세계관
        if(n > a_info[depth]){
            r_info[depth] = a_info[depth] + 1;
            dfs(a_info, r_info, n - r_info[depth], depth + 1);
            r_info[depth] = 0;
        }
        //화살을 쏘지 않는 세계관
        dfs(a_info, r_info, n, depth + 1);
    }
    
    //
    private void calculate(int[] a_info, int[] r_info){
        int a_score = 0;
        int r_score = 0;
        for(int i = 0; i<11; i++){
            
            if(a_info[i] == 0 && r_info[i] == 0) continue;
            
            if(a_info[i] >= r_info[i]){
                a_score += (10 - i);
            }else{
                r_score += (10 - i);
            }
        }
        
        if(r_score > a_score){
            int diff = r_score - a_score;
            if(maxDiff < diff){
                maxDiff = diff;
                answer = r_info.clone();
            }else if(maxDiff == diff && isBetter(r_info)){
                answer = r_info.clone();
            }
        }
        
    }
    
    private boolean isBetter(int[] r_info){
        for(int i = 10; i>-1; i--){
            if(answer[i] < r_info[i]){
                return true;
            }else if(answer[i] > r_info[i]){
                return false;
            }
        }
        return false;
    }
}