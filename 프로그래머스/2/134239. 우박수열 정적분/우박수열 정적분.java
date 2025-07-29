import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        // 1. 구간합 배열을 만들기
        //  1-1. y값의 변화를 담은 리스트 생성
        //  1-2. 1-1에서 만든 리스트로 구간별 넓이를 담은 리스트 생성
        //  1-3. 1-2에서 만든 리스트로 구간합 배열 생성
        // 2. 구간별 정적분값 O(1) 속도로 산출 후 배열에 저장
        
        List<Double> deltaY = new ArrayList<>();
        deltaY.add(Double.valueOf(k));
        while(k != 1){
            if(k%2 == 0){
                k/=2;
            }else{
                k*=3;
                k++;
            }
            deltaY.add(1.0*k);
        }
        
        List<Double> fragments = new ArrayList<>();
        for(int i = 1; i<deltaY.size(); i++){
            fragments.add((deltaY.get(i) + deltaY.get(i-1)) / 2.0);
        }
        
        double[] prefixSum = new double[fragments.size() + 1];
        for(int i = 1; i<prefixSum.length; i++){
            prefixSum[i] = prefixSum[i - 1] + fragments.get(i - 1);
        }
        
        double[] result = new double[ranges.length];
        int n = deltaY.size() - 1, idx = 0;
        for(int[] range : ranges){
            int s = range[0], e = range[1];
            if(e <= 0) e += n;
            if(s > e) result[idx++] = -1.0;
            else result[idx++] = prefixSum[e] - prefixSum[s];
        }
        
        return result;
    }
}