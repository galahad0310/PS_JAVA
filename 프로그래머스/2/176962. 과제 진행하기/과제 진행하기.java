import java.util.*;

class Solution {
    class Task{
        String name;
        int start, playtime;
        Task(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    public String[] solution(String[][] plans) {
        Task[] tasks = new Task[plans.length];
        for(int i = 0; i<tasks.length; i++){
            String name = plans[i][0];
            String[] s = plans[i][1].split(":");
            int start = Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]);
            int playtime = Integer.parseInt(plans[i][2]);
            tasks[i] = new Task(name, start, playtime);
        }
        
        Arrays.sort(tasks, (o1, o2) -> o1.start - o2.start);
        
        int time = tasks[0].start;
        Deque<Task> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i<tasks.length - 1; i++){
            Task curr = tasks[i];
            Task next = tasks[i+1];
            time = Math.max(curr.start, time);
            
            int available = next.start - time;
            
            //사용가능 시간이 playtime보다 많은 경우
            if(available > curr.playtime){
                time += curr.playtime;
                result.add(curr.name);
                //현재 과제 다 끝내고 멈춘 과제 시작
                while(!stack.isEmpty()){
                    int remainTime = next.start - time;
                    Task t = stack.pop();
                    if(remainTime > t.playtime){
                        time += t.playtime;
                        result.add(t.name);
                    }else if(remainTime == t.playtime){
                        time += t.playtime;
                        result.add(t.name);
                        break;
                    }else{
                        time += remainTime;
                        t.playtime -= remainTime;
                        stack.push(t);
                        break;
                    }
                }
                //사용 가능 시간이 playtime과 같은 경우
            }else if(available == curr.playtime){
                result.add(curr.name);
                time += available;
            }else{
                //사용 가능 시간이 playtime 보다 적은 경우
                time += available;
                curr.playtime -= available;
                stack.push(curr);
            }   
        }
        
        result.add(tasks[tasks.length - 1].name);
        
        while(!stack.isEmpty()){
            result.add(stack.pop().name);
        }
        
        return result.toArray(new String[0]);
    }
}