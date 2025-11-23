import java.util.*;

class Solution {
    char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    int answer = 0;
    public int solution(int n, String[] data) {
        dfs(new boolean[8], new char[8], 0, data);
        return answer;
    }
    
    void dfs(boolean[] used, char[] line, int depth, String[] data){
        if(depth == 8){
            if(validate(line, data)) answer++;
            return;
        }
        for(int i = 0; i < 8; i++){
            if(!used[i]){
                used[i] = true;
                line[depth] = friends[i];
                dfs(used, line, depth + 1, data);
                used[i] = false;
            }
        }
    }
    
    boolean validate(char[] line, String[] data){
        
        for(String condition : data){
            char c1 = condition.charAt(0);
            char c2 = condition.charAt(2);
            char op = condition.charAt(3);
            int c3 = condition.charAt(4) - '0';
            
            int[] arr = new int[128];
            
            for(int i = 0; i<8; i++){
                arr[line[i]] = i;
            }
            
            int x = Math.abs(arr[c1] - arr[c2]) - 1;
            
            switch(op){
                case '=':
                    if(x != c3) return false;
                    break;
                case '>':
                    if(x <= c3) return false;
                    break;
                case '<':
                    if(x >= c3) return false;
                    break;
            }
        }
        
        return true;
    }
    
}