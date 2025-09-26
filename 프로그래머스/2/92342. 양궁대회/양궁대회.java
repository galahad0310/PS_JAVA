class Solution {
    int[] answer = {-1};
    int maxDiff = -1;
    public int[] solution(int n, int[] info) {
        dfs(info, new int[11], n, 0);
        return answer;
    }

    private void dfs(int[] a_info, int[] r_info, int n, int depth){
        //갱신
        if(depth == 11){
            //화살이 남았다면 0점에 전부 소진
            if(n > 0){
                r_info[10] = n;
            }

            calculate(a_info, r_info);

            //백트래킹을 위한 상태 복구
            if(n > 0){
                r_info[10] = 0;
            }
            return;
        }

        //쏘는 경우
        if(n > a_info[depth]){
            r_info[depth] = a_info[depth] + 1;
            dfs(a_info, r_info, n - r_info[depth], depth + 1);
            r_info[depth] = 0;
        }

        //안쏘는 경우
        dfs(a_info, r_info, n, depth + 1);
    }

    private void calculate(int[] a_info, int[] r_info){
        int a_score = 0;
        int r_score = 0;

        for(int i = 0; i<11; i++){

            if(a_info[i] == 0 && r_info[i] == 0){
                continue;
            }

            if(r_info[i] > a_info[i]){
                r_score += (10 - i);
            }else{
                a_score += (10 - i);
            }
        }

        //라이언 승리
        if(r_score > a_score){
            int diff = r_score - a_score;
            if(maxDiff < diff){
                maxDiff = diff;
                answer = r_info.clone();
            }else if(maxDiff == diff && isBetter(r_info)){
                answer = r_info.clone();
            }
        }
        //라이언 패배시 고려안함
    }

    private boolean isBetter(int[] r_info){
        for(int i = 10; i>-1; i--){
            if(r_info[i] > answer[i]){
                return true;
            }else if(r_info[i] < answer[i]){
                return false;
            }
        }
        return false;
    }

}