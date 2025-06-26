import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] rocks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            rocks[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                int cost = (j - i) * (1 + Math.abs(rocks[i] - rocks[j]));
                if (cost <= k) {
                    dp[j] = true;
                }
            }
        }

        System.out.println(dp[n - 1] ? "YES" : "NO");
    }
}
