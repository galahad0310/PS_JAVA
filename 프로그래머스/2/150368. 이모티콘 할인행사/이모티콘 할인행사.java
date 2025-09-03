import java.util.*;
class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        List<List<Integer>> list = permute(4, emoticons.length);
        int[][] notes = new int[list.size()][2];
        
        for(int i = 0; i<notes.length; i++){
            List<Integer> ratios = list.get(i);
            for(int[] user : users){
                int want_ratio = user[0];
                int limit_price = user[1];
                double total = 0;
                for(int j = 0; j<ratios.size(); j++){
                    if(ratios.get(j) >= want_ratio){
                        total += ((1.0 * 100 - ratios.get(j)) / 100) * emoticons[j];
                    }
                    if(total >= limit_price) break;
                }
                if(total >= limit_price){
                    notes[i][0]++;
                }else{
                    notes[i][1] += total;
                }
            }
        }
        
        Arrays.sort(notes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        
        return notes[0];
    }
    
    List<List<Integer>> permute(int n, int r){
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(n, r, new ArrayList<>(), result);
        return result;
    }
    
    void permuteHelper(int n, int r, List<Integer> buffer, List<List<Integer>> result){
        if(r == 0){
            result.add(new ArrayList<>(buffer));
            return;
        }
        for(int i = 1; i<=n; i++){
            buffer.add(i * 10);
            permuteHelper(n, r-1, buffer, result);
            buffer.remove(buffer.size() - 1);
        }
    }
}