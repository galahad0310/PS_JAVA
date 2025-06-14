import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] pfs = new int[elements.length * 2];
        pfs[0] = elements[0];
        for(int i = 1; i<pfs.length; i++){
            pfs[i] = pfs[i-1] + elements[i % elements.length];    
        }
        
        for(int i = 1; i<=elements.length; i++){
            for(int j = 0; j<pfs.length - i; j++){
                set.add(pfs[j + i] - pfs[j]);
            }
        }
        
        return set.size();
    }
}