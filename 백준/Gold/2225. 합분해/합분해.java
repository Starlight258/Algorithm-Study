import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // dp[n] = 현재 k에 대해 합 n을 만드는 방법 수
        long[] dp = new long[N + 1];
        // k=1일 때: 어떤 n이든 {n} 한 가지
        Arrays.fill(dp, 1);

        for (int k = 2; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                dp[n] = (dp[n] + dp[n - 1]) % MOD; // dp[k][n] = dp[k][n-1] + dp[k-1][n]
            }
        }
        System.out.println(dp[N] % MOD);
    }
    // 0,,...N 정수 K개 -> 합이 N
    // dp[1] = 1;
    // dp[2] = dp[0]+dp[2], dp[1] + dp[1] , dp[2]+dp[0]
    // dp[3]= dp[0]+dp[3], dp[1]+dp[2], dp[2]+dp[1], dp[3]+dp[0]
    // dp[3] = dp[1] + dp[2] = dp[2] + dp[1]

}
