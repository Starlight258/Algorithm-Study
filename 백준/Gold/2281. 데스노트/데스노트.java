import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] names;
    static int[] dp;

    private static int dfs(int idx) {
        if (dp[idx] < Integer.MAX_VALUE) {
            return dp[idx];
        }

        int k = m - names[idx];
        for (int i = idx + 1; i <= n && k >= 0; i++) {
            if (i == n) {
                dp[idx] = 0;
                break;
            }
            dp[idx] = Math.min(dp[idx], k * k + dfs(i));
            k -= names[i] + 1;
        }
        return dp[idx];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        names = new int[n];
        for (int i = 0; i < n; i++) {
            names[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        System.out.println(dfs(0));

    }
}
