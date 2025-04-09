import java.util.*;
class Solution {
    class Node{
        String head, number, tail;
        Node(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
    public String[] solution(String[] files) {
        Node[] nodes = new Node[files.length];
        for(int i = 0; i<files.length; i++){
            nodes[i] = split(files[i]);
        }
        Arrays.sort(nodes, (o1, o2) -> {
            String head1 = o1.head.toLowerCase();
            String head2 = o2.head.toLowerCase();
            
            if(head1.compareTo(head2) == 0){
                return Integer.compare(Integer.parseInt(o1.number), Integer.parseInt(o2.number));
            }else{
                return head1.compareTo(head2);
            }
        });
        String[] answer = new String[nodes.length];
        for(int i = 0; i<answer.length; i++){
            answer[i] = new StringBuilder(nodes[i].head).append(nodes[i].number).append(nodes[i].tail).toString();
        }
        return answer;
    }
    Node split(String s){
        int number_start_idx = -1;
        int tail_start_idx = -1;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c) && number_start_idx == -1){
                number_start_idx = i;
            }
            if(!Character.isDigit(c) && number_start_idx != -1){
                tail_start_idx = i;
                break;
            }
        }
        String head = s.substring(0, number_start_idx);
        String number = "";
        String tail = "";
        if(tail_start_idx != -1){
            number = s.substring(number_start_idx, tail_start_idx);
            tail = s.substring(tail_start_idx, s.length());
        }else{
            number = s.substring(number_start_idx);
        }
        
        return new Node(head, number, tail);
    }
}