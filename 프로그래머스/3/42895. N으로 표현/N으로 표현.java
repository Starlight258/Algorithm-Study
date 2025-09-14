import java.util.*;

class Solution {
    private static int MAX = 8;
    
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>(MAX+1);
        for (int i=0;i<=MAX;i++){
            dp.add(new HashSet<>());
        }
        
        for (int k=1;k<=MAX;k++){
            int concat = concat(N, k);
            if (concat == number){
                return k;
            }
            dp.get(k).add(concat);
            
            // dp[k] = dp[i] + dp[k-i]
            for (int i=1;i<k;i++){
                Set<Integer> A = dp.get(i);
                Set<Integer> B = dp.get(k-i);
                
                for (int a:A){
                    for (int b:B){
                        dp.get(k).add(a+b);
                        dp.get(k).add(a-b);
                        dp.get(k).add(b-a);
                        dp.get(k).add(a*b);
                        if (b!=0) dp.get(k).add(a/b);
                        if (a!=0) dp.get(k).add(b/a);
                    }
                }
            }
            
            if (dp.get(k).contains(number)){
                return k;
            }
        }
                
        return -1;
    }
    
    private int concat(int N, int times){
        int val = 0;
        for (int i=0;i<times;i++){
            val = val * 10 + N;
        }
        return val;
    }
}