import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int num = 1;
        for(int r = 0; r<rows; r++){
            for(int c = 0; c<columns; c++){
                matrix[r][c] = num++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int[] q : queries){
            //0-based 조정
            int r1 = q[0] - 1;
            int c1 = q[1] - 1;
            int r2 = q[2] - 1;
            int c2 = q[3] - 1;
            int prev = matrix[r1][c1];
            int min = prev;
            //right
            for(int x = c1; x < c2; x++){
                int temp = prev;
                prev = matrix[r1][x+1];
                matrix[r1][x + 1] = temp;
                min = Math.min(min, prev);
            }
            //down
            for(int y = r1; y < r2; y++){
                int temp = prev;
                prev = matrix[y+1][c2];
                matrix[y+1][c2] = temp;
                min = Math.min(min, prev);
            }
            //left
            for(int x = c2; x>c1; x--){
                int temp = prev;
                prev = matrix[r2][x-1];
                matrix[r2][x-1] = temp;
                min = Math.min(min, prev);
            }
            //up
            for(int y = r2; y > r1; y--){
                int temp = prev;
                prev = matrix[y - 1][c1];
                matrix[y-1][c1] = temp;
                min = Math.min(prev, min);
            }
            
            list.add(min);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}