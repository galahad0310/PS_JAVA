class Solution {
    public int[] solution(String s) {
        int count = 0;
        int removed = 0;
        
        while(!s.equals("1")){
            int cnt0 = 0;
            for(char c : s.toCharArray()){
                if(c == '0'){
                    cnt0++;
                }
            }
            s = Integer.toString(s.length() - cnt0, 2);
            removed += cnt0;
            count++;
        }
        return new int[]{count, removed};
    }
}