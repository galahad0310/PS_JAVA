class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        
        boolean isFirst = true;
        
        for(char c : s.toCharArray()){
            if(c == ' '){
                isFirst = true;
                sb.append(' ');
            }else{
                if(isFirst){
                    sb.append(Character.toUpperCase(c));
                    isFirst = false;
                }else{
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}