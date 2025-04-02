import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        
        //아무래도 초기값을 지정해줘야 될거같다.
        left.put(topping[0], 1);
        for(int i = 1; i<topping.length; i++){
            right.put(topping[i], right.getOrDefault(topping[i], 0)+1);
        }
        
        //한칸씩 자르면서 시뮬레이션
        for(int i = 1; i<topping.length - 1; i++){
            //유효성 검사
            if(validate(left, right)){
                answer++;
            }
            //i에 맞게 cut
            cut(left, right, topping[i]);
        }
        return answer;
    }
    
    void cut(Map<Integer, Integer> left, Map<Integer, Integer> right, int item){
        left.put(item, left.getOrDefault(item, 0) + 1);
        if(right.get(item) == 1){
            right.remove(item);
        }else{
            right.put(item, right.get(item) - 1);
        }
    }
    
    boolean validate(Map<Integer, Integer> left, Map<Integer, Integer> right){
        return left.size() == right.size();
    }
    
}