import java.util.*;
class Solution {
    class Node implements Comparable<Node>{
        int idx;
        String name;
        int time;
        Node(int idx, String name, int time){
            this.idx = idx;
            this.name = name;
            this.time = time;
        }
        
        public int compareTo(Node o){
            if(this.time == o.time) return this.idx - o.idx;
            return o.time - this.time;
        }
    }
    public String solution(String m, String[] musicinfos) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        m = convert(m);
        
        int idx = 0;
        for(String s : musicinfos){
            Node node = extract(s, m, idx);
            if(node != null){
                pq.offer(node);
                idx++;
            }
        }
        
        if(pq.isEmpty()) return "(None)";
        return pq.poll().name;
    }
    
    String convert(String s) {
        return s.replace("A#", "a")
            .replace("B#", "b")
            .replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("E#", "e");
    }
    
    public Node extract(String s, String m, int idx){
        String[] arr = s.split(",");
        int time = fun1(arr[0], arr[1]);
        String name = arr[2];
        String music = fun2(convert(arr[3]), time);
        
        if(music.contains(m)){
            return new Node(idx, name, time);
        }
        
        return null;
    }
    
    
    public String fun2(String s, int time){
    
        if(time <= s.length()){
            return s.substring(0, time);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<time; i++){
            sb.append(s.charAt(i % s.length()));
        }

        return sb.toString();
    }
    
    public int fun1(String start, String end){
        String[] arr1 = start.split(":");
        String[] arr2 = end.split(":");
        int a = Integer.parseInt(arr1[0]) * 60;
        int b = Integer.parseInt(arr1[1]);
        int c = Integer.parseInt(arr2[0]) * 60;
        int d = Integer.parseInt(arr2[1]);
        
        return (c+d) - (a+b);
    }
}