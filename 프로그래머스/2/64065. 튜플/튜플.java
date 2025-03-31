import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] arr = s.split("-");

        List<List<Integer>> list = new ArrayList<>();
        for(String str : arr){
            List<Integer> temp = new ArrayList<>();
            for(String num : str.split(",")){
                temp.add(Integer.parseInt(num));
            }
            list.add(temp);
        }

        list.sort(Comparator.comparingInt(List::size));

        Set<Integer> set = new LinkedHashSet<>();
        for(List<Integer> l : list){
            for(int num : l){
                set.add(num);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
