import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int s;
    static int m;
    static int[] volumes;
    static boolean[][] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        volumes = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[n][50001];
        answer = -1;
        dfs(0, s);

        System.out.println(answer);
    }

    private static void dfs(int idx, int sum) {
        if (idx == n) {
            answer = Math.max(sum, answer);
            return;
        }
        if (dp[idx][sum]) {
            return;
        }
        dp[idx][sum] = true;

        if (sum + volumes[idx] >= 0 && sum + volumes[idx] <= m) {
            dfs(idx + 1, sum + volumes[idx]);
        }
        if (sum - volumes[idx] >= 0 && sum - volumes[idx] <= m) {
            dfs(idx + 1, sum - volumes[idx]);
        }
    }
}
