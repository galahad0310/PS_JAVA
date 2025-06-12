class Solution {
    public int solution(int n) {
        int cnt = Integer.toString(n, 2).replace("0", "").length();
        while(cnt != Integer.toString(++n, 2).replace("0", "").length()){}
        return n;
    }
}