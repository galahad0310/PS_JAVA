import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int[][] book_time_minute = new int[book_time.length][2];
        for(int i = 0; i<book_time_minute.length; i++){
            book_time_minute[i] = convert_to_minute(book_time[i]);
        }
        
        Arrays.sort(book_time_minute, (a, b) -> {
            return a[0] > b[0] ? 1 : -1;
        });
        
        Map<Integer, Integer> rooms = new HashMap<>();
        int room_no = 0;
        for(int[] time : book_time_minute){
            int s = time[0];
            int e = time[1];
            
            boolean isCheckin = false;
            
            for(int key : rooms.keySet()){
                if(rooms.get(key) <= s){
                    rooms.put(key, e+10);
                    isCheckin = true;
                    break;
                }
            }
            
            if(!isCheckin){
                rooms.put(room_no++, e+10);
            }
        }
        return rooms.size();
    }
    
    int[] convert_to_minute(String[] s){
        int[] arr = new int[2];
        int idx = 0;
        
        for(String str : s){
            String[] split = str.split(":");
            arr[idx++] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        
        return arr;
    }
}