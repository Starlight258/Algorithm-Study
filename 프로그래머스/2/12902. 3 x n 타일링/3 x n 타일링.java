class Solution {
    int mod = 1000000007;
    long dp[] = new long[5004];
    public int solution(int n) {
        int answer = 0;
        if (n%2==1) return 0;
        dp[2] = 3;
        dp[4] = 11;
        for (int i=6; i<=n;i+=2){
            dp[i] = ((4 * dp[i-2] % mod)- (dp[i-4] % mod) + mod) % mod;
        }
        return (int) dp[n];
    }
}