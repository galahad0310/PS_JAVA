class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] numbers = {"4", "1", "2"}; 

        while (n > 0) {
            int remainder = n % 3;
            answer.insert(0, numbers[remainder]); 
            
            if (remainder == 0) {
                n = (n / 3) - 1;
            } else {
                n = n / 3;
            }
        }

        return answer.toString();
    }
}