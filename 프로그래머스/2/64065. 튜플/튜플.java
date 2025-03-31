import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        List<List<Integer>> list = new ArrayList<>();
        int idx = 0;
        StringBuilder num = new StringBuilder();
        list.add(new ArrayList<>());
        for(int i = 1; i<s.length()-1; i++){
            char c = s.charAt(i);
            if(c == '{'){
                list.add(new ArrayList<>());
                idx++;
            }else if(Character.isDigit(c)){
                num.append(c);
            }else{
                if(!num.toString().equals("")){
                    list.get(idx).add(Integer.parseInt(num.toString()));
                    num = new StringBuilder();
                }
            }
        }
        
        Collections.sort(list, (o1, o2) -> o1.size() - o2.size());
        
        Set<Integer> answer = new LinkedHashSet<>();
        
        for(int i = 0; i<list.size(); i++){
            List<Integer> l = list.get(i);
            for(int j : l){
                if(!answer.contains(j)){
                    answer.add(j);
                }
            }
        }
        
        int[] arr = new int[answer.size()];
        int k = 0;
        for(int i : answer){
            arr[k++] = i;
        }
        
        return arr;
    }
}