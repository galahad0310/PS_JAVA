class Solution {
    public int solution(String[] board) {
        int o = 0, x = 0;
        
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(board[i].charAt(j) == 'O') o++;
                else if(board[i].charAt(j) == 'X') x++;
            }
        }
        if(!(o == x || o == x+1)) return 0;
        
        boolean oEnd = check('O', board);
        boolean xEnd = check('X', board);
        
        if(oEnd && xEnd) return 0;
        
        if(oEnd && o != x+1) return 0;
        
        if(xEnd && o != x) return 0;
        
        return 1;
    }
    
    boolean check(char c, String[] board){
        for(int i = 0; i<3; i++){
            if(c == board[i].charAt(0) && c == board[i].charAt(1) && c == board[i].charAt(2)){
                return true;
            }
        }
        
        for(int i = 0; i<3; i++){
            if(c == board[0].charAt(i) && c == board[1].charAt(i) && c == board[2].charAt(i)){
                return true;
            }
        }

        if(c == board[0].charAt(0) && c == board[1].charAt(1) && c == board[2].charAt(2)){
            return true;
        }
        
        if(c == board[0].charAt(2) && c == board[1].charAt(1) && c == board[2].charAt(0)){
            return true;
        }
        
        return false;

    }
}