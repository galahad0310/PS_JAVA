import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int[][] times = convert_to_minute(book_time);
        
        Arrays.sort(times, (a, b) -> {
            return a[0] > b[0] ? 1 : -1; 
        });
        
        int room_no = 0;
        Map<Integer, Integer> rooms = new HashMap<>();
        
        for(int[] book : times){
            int start = book[0];
            int end = book[1];
            
            boolean checkIn = false;
            
            for(Integer key : rooms.keySet()){
                if(rooms.get(key) <= start){
                    rooms.put(key, end + 10);
                    checkIn = true;
                    break;
                }
            }
            
            if(!checkIn){
                rooms.put(room_no++, end + 10);    
            }
        }
        return rooms.size();
    }
    
    int[][] convert_to_minute(String[][] book_time){
        int[][] times = new int[book_time.length][2];
        int idx = 0;
        for(String[] time : book_time){
            int start = func(time[0]);
            int end = func(time[1]);
            times[idx][0] = start;
            times[idx++][1] = end;
        }
        return times;
    }
    
    int func(String s){
        String[] arr = s.split(":");
        int a = Integer.parseInt(arr[0]) * 60;
        int b = Integer.parseInt(arr[1]);
        return a+b;
    }
    
}