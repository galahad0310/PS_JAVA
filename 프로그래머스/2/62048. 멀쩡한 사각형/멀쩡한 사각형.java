class Solution {
    public long solution(int w, int h) {
        long result = (long)w*h - w - h;
        while(h!=0){
            int temp = h;
            h = w % h;
            w = temp;
        }
        return result + w;
    }
}