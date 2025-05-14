import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for(String log : record){
            String[] arr = log.split(" ");
            String cmd = arr[0];
            String id = arr[1];
            if(cmd.equals("Enter")){
                map.put(id, arr[2]);
                list.add(cmd + " " + id);
            }else if(cmd.equals("Change")){
                map.put(id, arr[2]);
            }else{
                list.add(cmd + " " + id);
            }
        }
        String[] answer = new String[list.size()];
        for(int i = 0; i<answer.length; i++){
            String[] arr = list.get(i).split(" ");
            String cmd = arr[0];
            String nickName = map.get(arr[1]);
            answer[i] = convert(cmd, nickName);
        }
        return answer;
    }
    
    String convert(String cmd, String nickName){
        if(cmd.equals("Enter")){
            return nickName+"님이 들어왔습니다.";
        }
        return nickName+"님이 나갔습니다.";
    }
}