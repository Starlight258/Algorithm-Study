import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] profits = new int[n + 1][2];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            profits[i] = new int[]{a, b};
        }

        //2. dp 수행
        int[] dp = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            int t = profits[i][0];
            int p = profits[i][1];
            if (i + t <= n + 1) {
                dp[i + t] = Math.max(dp[i + t], dp[i] + p);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n + 1]);
    }
}
