class Solution {
    int mod = 1000000007;
    long dp[] = new long[5004];
    long findAnswer(int n){
        if (n==2) return 3;
        if (n==4) return 11;
        if (dp[n]!=0){
            return dp[n];
        }
        return dp[n] = ((findAnswer(n-2) * 4 % mod) - (findAnswer(n-4) % mod) + mod) % mod;
    }
    public int solution(int n) {
        int answer = 0;
        if (n%2==1) return 0;
        answer = (int) findAnswer(n);
        return  answer;
    }
}