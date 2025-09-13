class Solution {
    
    static int[] col; //해당 행에서 퀸이 있는 column을 저장하고 있는 배열
    static int cnt; //조건을 만족하는 경우의 수
    static int n;
    
    public int solution(int n) {
        //상태 초기화
        this.n = n;
        this.cnt = 0;
        this.col = new int[n];
        
        dfs(0);
        return cnt;
    }
    
    //하나의 row엔 퀸 하나가 포함되어 있음->row를 depth로 생각
    void dfs(int row){
        if(row == n){
            cnt++;
            return;
        }
        
        for(int i = 0; i<n; i++){
            if(validate(row, i)){
                col[row] = i;
                dfs(row+1);
                col[row] = 0; //관례상 추가해둔 코드
            }
        }
    }
    
    boolean validate(int row, int column){
        for(int prev = 0; prev < row; prev++){
            if(col[prev] == column) return false; //퀸과 같은 열에 있는 경우
            if(Math.abs(col[prev] - column) == Math.abs(prev - row)) return false; //퀸의 대각선과 겹치는 경우
        }
        return true;
    }
}