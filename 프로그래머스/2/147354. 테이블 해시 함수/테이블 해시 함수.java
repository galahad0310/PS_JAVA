import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[col-1] != arr2[col-1]){
                    return Integer.compare(arr1[col-1], arr2[col-1]);
                }else{
                    return Integer.compare(arr2[0], arr1[0]);
                }
            }
        });
        int answer = 0;
        for(int i = row_begin - 1; i < row_end; i++){
            int si = 0;
            for(int j = 0; j<data[i].length; j++){
                si += (data[i][j] % (i+1));
            }
            if(i == row_begin - 1){
                answer = si;
            }else{
                answer ^= si;
            }
        }
        return answer;
    }
}