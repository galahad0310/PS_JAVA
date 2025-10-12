import java.util.*;
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        
        //검색을 빠르게 하기 위한 map 생성
        for(String data : info){
            String[] arr = data.split(" ");
            int score = Integer.parseInt(arr[4]);
            arr = new String[]{arr[0], arr[1], arr[2], arr[3]};
            dfs(arr, "", 0, score);
        }
        
        //LowerBound를 위한 정렬
        for(List<Integer> list : map.values()){
            Collections.sort(list);
        }
        
        
        int[] answer = new int[query.length];
        int idx = 0;
        //검색
        for(String q : query){
            //replace는 새로운 String을 리턴하는 걸로 알고 있음
            q = q.replace(" and ", " ");
            String[] arr = q.split(" ");
            
            int score = Integer.parseInt(arr[4]);
            String key = arr[0] + arr[1] + arr[2] + arr[3];
            
            int count = 0;
            if(map.containsKey(key)){
                count = lowerBound(map.get(key), score);
            }
            
            answer[idx++] = count;
        }
        
        return answer;
    }
    
    private int lowerBound(List<Integer> list, int score){
        int s = 0, e = list.size() - 1, r = -1;
        
        while(s <= e){
            int m = (s+e)/2;
            
            if(list.get(m) >= score){
                e = m-1;
                r = m;
            }else{
                s = m + 1;
            }
        }
        
        return r!= -1 ? list.size() - r : 0;
    }
    
    private void dfs(String[] arr, String key, int depth, int score){
        if(depth == 4){
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }
        dfs(arr, key + "-", depth + 1, score);
        dfs(arr, key + arr[depth], depth + 1, score);
    }
}