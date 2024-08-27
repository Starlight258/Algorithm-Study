import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final long MOD = 1_000_000_007;

    static int s;
    static int a;
    static int b;
    static int c;
    static long dp[][][][]; // 곡수, a,b,c

    private static long dfs(int s, int a, int b, int c) {
        if (s == 0) {
            return (a == 0 && b == 0 && c == 0) ? 1 : 0; // 모두 사용
        }

        if (a < 0 || b < 0 || c < 0) {
            return 0;
        }

        if (dp[s][a][b][c] != -1) {
            return dp[s][a][b][c];
        }

        long result = 0;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 1; k++) {
                    if (i + j + k > 0) {
                        result += dfs(s - 1, a - i, b - j, c - k);
                    }
                }
            }
        }

        return dp[s][a][b][c] = result % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dp = new long[s + 1][a + 1][b + 1][c + 1];

        for (int i = 0; i <= s; i++) {
            for (int j = 0; j <= a; j++) {
                for (int k = 0; k <= b; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        System.out.println(dfs(s, a, b, c));
    }
}
