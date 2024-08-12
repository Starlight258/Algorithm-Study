import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final long MOD = 1_000_000_007;

    static long[][][][] dp;
    static int n;
    static int d;
    static int k;
    static int h;

    private static long solve(int n, int d, int k, int h) {
        if (n == 0) {
            return (d == 0 && k == 0 && h == 0) ? 1 : 0;
        }

        if (d < 0 || k < 0 || h < 0) {
            return 0;
        }

        if (dp[n][d][k][h] != -1) {
            return dp[n][d][k][h];
        }

        long result = 0;
        for (int i = 0; i <= 1; i++) { // 부르느냐 부르지 않느냐 경우 구함
            for (int j = 0; j <= 1; j++) {
                for (int l = 0; l <= 1; l++) {
                    if (i + j + l > 0) { // 세명 중 한명은 불러야함
                        result += solve(n - 1, d - i, k - j, h - l);
                    }
                }
            }
        }

        return dp[n][d][k][h] = result % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        dp = new long[n + 1][d + 1][k + 1][h + 1]; // 곡수, 각각의 곡 수

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= d; j++) {
                for (int l = 0; l <= k; l++) {
                    Arrays.fill(dp[i][j][l], -1);
                }
            }
        }

        System.out.println(solve(n, d, k, h));
    }
}
