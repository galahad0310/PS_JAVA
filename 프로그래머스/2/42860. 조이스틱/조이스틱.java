class Solution {
    public int solution(String name) {
        int answer = 0;
        int minMove = name.length() - 1;
        for(int i = 0; i<name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A'){
                next++;
            }
            minMove = Math.min(minMove, i * 2 + name.length() - next);
            minMove = Math.min(minMove, i + (name.length() - next) * 2);
        }
        answer+=minMove;
        return answer;
    }
}