class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];

            if (n % 2 == 0) {
                // 짝수는 바로 다음 수가 비트 1개만 다름
                answer[i] = n + 1;
            } else {
                // 홀수는 2비트 다르게 만드는 공식 적용
                long bit = 1L;
                while ((n & bit) != 0) {
                    bit <<= 1;
                }
                answer[i] = n + bit - (bit >> 1);
            }
        }

        return answer;
    }
}
