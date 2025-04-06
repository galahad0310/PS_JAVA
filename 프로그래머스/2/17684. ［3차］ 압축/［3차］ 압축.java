import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<26; i++){
            char c = (char)(i+'A');
            map.put(String.valueOf(c), i+1);
        }
        int v = 27;
        List<Integer> list = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i<msg.length(); i++){
            buffer.append(msg.charAt(i));
            if(!map.containsKey(buffer.toString())){
                map.put(buffer.toString(), v++);
                buffer.deleteCharAt(buffer.length() - 1);
                String prev = buffer.toString();
                list.add(map.get(prev));
                buffer = new StringBuilder();
                buffer.append(msg.charAt(i));
            }
        }
        list.add(map.get(buffer.toString()));
        
        return list.stream().mapToInt(i->i).toArray();
    }
}