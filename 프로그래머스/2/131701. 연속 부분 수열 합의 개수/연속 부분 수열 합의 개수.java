import java.util.*;
class Solution {
    public int solution(int[] elements) {
        //중복을 허용하지 않으므로 set사용
        Set<Integer> set = new HashSet<>();
        
        //부분수열의 합을 O(1) 속도로 계산하기 위한 합배열 생성
        int[] pfs = new int[elements.length * 2];
        pfs[0] = elements[0];
        
        for(int i = 1; i<pfs.length; i++){
            pfs[i] = pfs[i-1] + elements[i % elements.length];    
        }
        
        //i는 부분수열의 길이: 1~elements.length
        for(int i = 1; i<=elements.length; i++){
            //길이인 i가 정해졌을 때 생성 가능한 부분수열 경우의 수 탐색하기 위한 변수
            for(int j = 0; j<pfs.length - i; j++){
                set.add(pfs[j + i] - pfs[j]);
            }
        }
        
        return set.size();
    }
}