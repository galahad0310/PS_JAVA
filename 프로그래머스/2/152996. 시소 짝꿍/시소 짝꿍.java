import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        double[] ratios = new double[]{1.0/1, 2.0/3, 1.0/2, 3.0/4};
        
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        
        for(int w : weights){
            for(double ratio : ratios){
                if(map.containsKey(w*ratio)){
                    answer+=map.get(w*ratio);
                }
            }
            map.put((double)w, map.getOrDefault((double)w, 0)+1);
        }
        
        return answer;
    }
}