import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<List<Integer>> list = new ArrayList<>();
        String[] arr = s.substring(2, s.length() - 2).split("},\\{");
        
        for(String str : arr){
            List<Integer> temp = new ArrayList<>();
            for(String n : str.split(",")){
                temp.add(Integer.parseInt(n));
            }
            list.add(temp);
        }
        Collections.sort(list, (o1, o2) -> o1.size() - o2.size());
        Set<Integer> set = new LinkedHashSet<>();
        for(List<Integer> l : list){
            for(int i : l){
                set.add(i); // 어차피 중복은 set에 안들어감
            }
        }
        return set.stream().mapToInt(i->i).toArray();
    }
}