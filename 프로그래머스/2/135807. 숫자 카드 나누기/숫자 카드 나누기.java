import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = gcdOfArray(arrayA);
        int gcdB = gcdOfArray(arrayB);
        
        int answer = 0;

        if (isNotDivisible(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }

        if (isNotDivisible(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    // 배열의 최대공약수
    private int gcdOfArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    // 두 수의 GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 배열의 어떤 수로도 gcd가 나눠지지 않으면 true
    private boolean isNotDivisible(int[] arr, int gcd) {
        for (int num : arr) {
            if (num % gcd == 0) return false;
        }
        return true;
    }
}
