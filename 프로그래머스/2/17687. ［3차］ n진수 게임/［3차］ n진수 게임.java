import java.util.*;
class Solution {
        //빡구현 = 모듈화
        //trigger를 만들어서 동적으로 배열 사이즈 증가 전략
        //1. 원본 숫자 -> n진수 변환 
        //2. 한자리씩 하나씩 끊어서 배열에 추가 -> m을 이용하여 p번째 순서에 있는 값 추출
        
    List<Character> array = new ArrayList<>();
    int num = 0;
    int pointer;
    
    public String solution(int n, int t, int m, int p) {
        pointer = p - 1;
        StringBuilder sb = new StringBuilder();
        while(t > 0){
            while(array.size() - 1 < pointer){
                append(n);
            }
            sb.append(array.get(pointer));
            pointer += m;
            t--;
        }
        return sb.toString();
    }
    
    void append(int n){
        String convert = Integer.toString(num, n);
        for(char c : convert.toCharArray()){
            array.add(Character.toUpperCase(c));
        }
        num++;
    }
}