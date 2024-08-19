import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Load {
        int t;
        int p;

        public Load(final int t, final int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Load[] times = new Load[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            times[i] = new Load(a, b);
        }

        int[] dp = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i]);
            Load time = times[i];
            if (i + time.t <= n + 1) {
                dp[i + time.t] = Math.max(dp[i + time.t], dp[i] + time.p);
            }
        }

        System.out.println(Math.max(dp[n], dp[n + 1]));
    }
}
