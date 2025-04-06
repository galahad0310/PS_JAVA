import java.util.*;
class Solution {
    char[] arr;
    public int solution(String skill, String[] skill_trees) {
        Set<Character> set = new HashSet<>();
        arr = new char[skill.length()];
        int idx = 0;
        for(char c : skill.toCharArray()){
            set.add(c);
            arr[idx++] = c;
        }
        int answer = 0;
        for(String s : skill_trees){
            if(validate(s, set)){
                answer++;
            }
        }
        return answer;
    }
    boolean validate(String s, Set<Character> set){
        int pointer = 0;
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                if(c == arr[pointer]){
                    pointer++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}