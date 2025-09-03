import java.util.*;
class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        List<List<Integer>> permute = permutation(4, emoticons.length);
        int[][] result = new int[permute.size()][2];
        
        for(int i = 0; i<result.length; i++){
            List<Integer> list = permute.get(i);
            for(int[] user : users){
                int want_sale = user[0]; //원하는 할인율
                int want_limit = user[1]; //이 금액이 넘어가면 이모티콘 플러스 삼
                double totalPrice = 0; //산 금액 저장
                
                for(int j = 0; j<list.size(); j++){
                    if(list.get(j) >= want_sale){
                        double x = (1.0 * 100 - list.get(j)) / 100;
                        totalPrice += x * emoticons[j];
                    }
                    if(totalPrice >= want_limit) break;
                }
                
                if(totalPrice >= want_limit){
                    result[i][0]++;
                }else{
                    result[i][1] += totalPrice;
                }
            }
        }
        Arrays.sort(result, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        return result[0];
    }
    
    List<List<Integer>> permutation(int n, int r){
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(n, r, new ArrayList<Integer>(), result);
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