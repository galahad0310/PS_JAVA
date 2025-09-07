import java.util.*;
class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        // 할인율 마다 결과값(가입 횟수, 비용)을 도출, 결과값 정렬
        // 1. 할인율은 중복 순열 알고리즘으로 모든 경우의 수 도출
        // 2. 경우의 수 마다 계산 후, 배열에 저장
        // 3. 배열 정렬후 리턴
        
        List<List<Integer>> cases = permute(4, emoticons.length);
        int[][] results = new int[cases.size()][2];
        int idx = 0;
        for(List<Integer> c : cases){
            for(int[] user : users){
                int r1, r2 = 0;
                for(int i = 0; i<c.size(); i++){
                    if(c.get(i) >= user[0]){
                        r2 += 1.0 * emoticons[i] * (1.0 * 100 - c.get(i))/100;
                    }
                    if(r2 >= user[1]) break;
                }
                if(r2 >= user[1]){
                    results[idx][0]++;
                }else{
                    results[idx][1] += r2;
                }
            }
            idx++;
        }
        Arrays.sort(results, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        
        return results[0];
    }
    
    List<List<Integer>> permute(int n, int r){
        List<List<Integer>> cases = new ArrayList<>();
        permuteHelper(n, r, new ArrayList<>(), cases);
        return cases;
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