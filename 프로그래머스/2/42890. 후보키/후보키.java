import java.util.*;
class Solution {
    //1~Column의 길이: 속성 조합하기 (뽑은 속성 중, 후보키가 포함되어있다면 그건 제외)
    //속성 조합을 검사하기: (1, 3) idx의 속성을 쭉 검사해야함(당장 생각나는건 SET사용? )
    //중복 되는게 하나도 없다면, 후보키 리스트에 추가
    public int solution(String[][] relation) {
        int n = relation[0].length;
        List<List<Integer>> candidateKeyList = new ArrayList<>(); 
        
        for(int r = 1; r<=n; r++){
            boolean isCandidateKey = true;
            for(List<Integer> list : combination(n, r)){
                
                //1. 최소성 검사: list안에 후보키 리스트의 것이 포함되었다면 continue해야함
                boolean isMinimum = true;
                for(List<Integer> candidate : candidateKeyList){
                    if(list.containsAll(candidate)){
                        isMinimum = false;
                        break;
                    }
                }
                if(!isMinimum) continue;
                
                //2. 유일성 검사: set를 활용해서 relation의 모든 튜플 검사
                //list에서 꺼낼때 0-based로 변환해야 되니 각각 -1 해주기
                boolean isUnique = true;
                
                Set<String> set = new HashSet<>();
                for(int i = 0; i<relation.length; i++){
                    StringBuilder sb = new StringBuilder();
                    for(int j : list){
                        sb.append(relation[i][j - 1]);
                    }
                    if(!set.add(sb.toString())){
                        isUnique = false;
                        break;
                    }
                }
                
                if(!isUnique){
                    continue;
                }
                
                candidateKeyList.add(new ArrayList<>(list));
            }
        }
        return candidateKeyList.size();
        //후보키 리스트의 개수 리턴
    }
    
    List<List<Integer>> combination(int n, int r){
        return combineHelper(n, r, 1, new ArrayList<>(), new ArrayList<>());
    }
    
    List<List<Integer>> combineHelper(int n, int r, int start, List<Integer> buffer, List<List<Integer>> result){
        if(r == 0){
            result.add(new ArrayList<>(buffer));
            return result;
        }
        
        for(int i = start; i<=n; i++){
            buffer.add(i);
            combineHelper(n, r-1, i+1, buffer, result);
            buffer.remove(buffer.size() - 1);
        }
        
        return result;
    }
}