import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // DP[i][j] : 현재 i칸, 지금까지 j칸(현재칸 포함) = 점수
    // 세 칸을 연속으로 밟아서는 안된다.
    // DP[i][1] = Math.max(DP[i-2][1], DP[i-2][2]) + S[i]
    // DP[i][2] = DP[i-1][1] + S[i]
    // DP[1][1] = S[1]
    // DP[1][2] = 0
    // DP[2][1] = S[2]
    // DP[2][2] = S[1] + S[2]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[305][3];
        int[] s = new int[305];
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }
        dp[1][1] = s[1];
        dp[1][2] = 0;
        dp[2][1] = s[2];
        dp[2][2] = s[1] + s[2];
        for (int i = 3; i <= n; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + s[i];
            dp[i][2] = dp[i - 1][1] + s[i];
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }

}
