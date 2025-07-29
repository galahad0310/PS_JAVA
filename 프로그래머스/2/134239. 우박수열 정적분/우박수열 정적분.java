import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> list = new ArrayList<>();
        list.add(k);
        while(k!=1){
            if(k%2 == 0){
                k/=2;
            }else{
                k*=3;
                k++;
            }
            list.add(k);
        }
        
        double[] arr = new double[list.size() - 1];
        for(int i = 0; i<list.size() - 1; i++){
            arr[i] = 1.0 * (list.get(i + 1) + list.get(i)) / 2;
        }
        
        double[] sum = new double[arr.length+1];
        for(int i = 1; i<sum.length; i++){
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        
        int n = sum.length - 1;
        double[] result = new double[ranges.length];
        
        int idx = 0;
        for(int[] range : ranges){
            int a = range[0], b = range[1];
            if(b <= 0) b = n+b;
            if(a > b){
                result[idx++] = -1.0;
            }else{
                result[idx++] = sum[b] - sum[a];
            }
        }
        return result;
    }
}