class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        
        boolean flag = true;
        for(int i = 0; i<arr.length; i++){
            if(flag){
                if(arr[i] != ' '){
                    arr[i] = Character.toUpperCase(arr[i]);
                    flag = false;
                }    
            }else{
                if(arr[i] == ' '){
                    flag = true;
                }
                if(Character.isUpperCase(arr[i])){
                    arr[i] = Character.toLowerCase(arr[i]);
                }
            }
        }
        return new String(arr);
    }
}