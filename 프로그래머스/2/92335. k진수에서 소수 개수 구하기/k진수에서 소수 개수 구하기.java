import java.util.*;
class Solution {
    public int solution(int n, int k) {
        return filter(findPrime(findNum(Integer.toString(n, k)))).size();
    }
    
    List<Long> filter(List<Long> primes){
        List<Long> list = new ArrayList<>();
        for(long i : primes){
            String s = String.valueOf(i);
            boolean isContain0 = false;
            for(char c : s.toCharArray()){
                if(c=='0'){
                    isContain0 = true;
                }
            }
            if(!isContain0){
                list.add(i);
            }
        }
        return list;
    }
    
    List<Long> findPrime(List<Long> numbers){
        List<Long> list = new ArrayList<>();
        for(long i : numbers){
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }
    
    boolean isPrime(long n){
        if(n == 1) return false;
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    List<Long> findNum(String s){
        String[] arr = s.split("0+");
        List<Long> list = new ArrayList<>();
        for(String n : arr){
            list.add(Long.parseLong(n));
        }
        return list;
    }
}