class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for(int i = 0; i<m; i++){
            map[i] = board[i].toCharArray();
        }
        int answer = 0;
        boolean isDelete;
        do{
            isDelete = false;
            boolean[][] check = new boolean[m][n];
            for(int y = 0; y<m-1; y++){
                for(int x = 0; x<n-1; x++){
                    char c = map[y][x];
                    if(c == ' ') continue;
                    if(c == map[y+1][x] 
                      && c == map[y][x+1]
                      && c == map[y+1][x+1]){
                        check[y][x] 
                            = check[y+1][x] 
                            = check[y][x+1] 
                            = check[y+1][x+1]
                            = true;
                        isDelete = true;
                    }
                }
            }
            
                for(int y = 0; y<m; y++){
                    for(int x = 0; x<n; x++){
                        if(check[y][x]){
                            map[y][x] = ' ';
                            answer++;
                        }
                    }
                }
             
                for(int y = m - 1; y > 0; y--){
                    for(int x = 0; x < m; x++){
                        if(map[y][x] == ' '){
                            int ny = y;
                            for(int k = y - 1; k > -1; k--){
                                if(map[k][x] != ' '){
                                    map[ny--][x] = map[k][x];
                                    map[k][x] = ' ';
                                }
                            }
                        }
                    }
                }
        }while(isDelete);
        return answer;
    }
}