class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String n : s.split(" ")){
            int i = Integer.parseInt(n);
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        
        return min + " " + max;
    }
}