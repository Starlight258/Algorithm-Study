import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long[][] dp;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        long i = Long.parseLong(st.nextToken());

        dp = new long[n + 1][l + 1];
        for (int j = 0; j <= n; j++) {
            for (int k = 0; k <= l; k++) {
                if (j == 0 || k == 0) {
                    dp[j][k] = 1;
                } else {
                    dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
                }
            }
        }
        if (dp[n][l] < i) {
            System.out.println(-1);
        } else {
            buildd(n, l, i);
            System.out.println(sb);
        }
    }

    private static void buildd(final int n, final int l, final long i) {
        if (n == 0) {
            return;
        }
        long left = dp[n - 1][l];
        if (i <= left) {
            sb.append("0");
            buildd(n - 1, l, i);
        } else {
            sb.append("1");
            buildd(n - 1, l - 1, (int) (i - left));
        }
    }
}
