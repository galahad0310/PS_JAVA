class Solution {
    public int solution(int[] arr) {
        int r = arr[0];
        for(int i = 1; i<arr.length; i++){
            r = lcm(r, arr[i]);
        }
        return r;
    }
    
    private int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
    
    private int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}