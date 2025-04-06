import java.util.*;
class Solution {
    class Car{
        int num, fee;
        Car(int num, int fee){
            this.num = num;
            this.fee = fee;
        }
    }
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> used = new HashMap<>();
        
        for(String s : records){
            String[] arr = s.split(" ");
            int minute = convert(arr[0]);
            if(arr[2].equals("IN")){
                map.put(arr[1], minute);
            }else{
                int usedTime = minute - map.get(arr[1]);
                used.put(arr[1], used.getOrDefault(arr[1], 0) + usedTime);
                map.remove(arr[1]);
            }
        }
        
        for(String s : map.keySet()){
            int minute = map.get(s);
            int usedTime = 23 * 60 + 59 - minute;
            used.put(s, used.getOrDefault(s, 0) + usedTime);
        }
        
        
        Car[] car = new Car[used.size()];
        int idx = 0;
        for(String s : used.keySet()){
            int fee = cal(used.get(s), fees);
            car[idx++] = new Car(Integer.parseInt(s), fee);
        }
        
        Arrays.sort(car, (o1, o2) -> o1.num - o2.num);
        idx = 0;
        int[] answer = new int[car.length];
        for(Car c : car){
            answer[idx++] = c.fee;
        }
        return answer;
    }
    
    int cal(int minute, int[] fees){
        if(minute > fees[0]){
            return fees[1]+(int)Math.ceil((1.0 * (minute - fees[0])) / fees[2]) * fees[3];
        }else{
            return fees[1];
        }
    }
    
    int convert(String s){
        String[] arr = s.split(":");
        int h = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        m += h * 60;
        return m;
    }
}