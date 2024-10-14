import java.util.*;

class Solution {
    public int solution(int n, int k) {
        // 1. 정수 n을 k진수로 바꾼다.
        String value = Integer.toString(n, k);
        // 2. 0을 기준으로 split하여 해당 숫자가 소수인지 판단한다.
        String[] splited = value.split("0");
        int answer = 0;
        for (String s:splited){
            if (s.isEmpty()) continue;
            long num = Long.parseLong(s);
            if (isPrime(num)){
                answer++;
            }
        }
        // 3. 소수의 개수를 return 한다.
        return answer;
    }
    private boolean isPrime(Long num){
        if (num == 1) return false;
        for (long i=2;i*i<=num;i++){
            if (num%i==0) return false;
        }
        return true;
    }
    
}
// 1. 정수 n을 k진수로 바꾼다.
// 2. 0을 기준으로 split하여 해당 숫자가 소수인지 판단한다.
// 3. 소수의 개수를 return 한다.