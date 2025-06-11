class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        
        for(String n : arr){
            min = Math.min(Long.parseLong(n), min);
            max = Math.max(Long.parseLong(n), max);
        }
        
        return min+" "+max;
    }
}