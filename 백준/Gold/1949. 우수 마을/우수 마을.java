import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] inhabits;
    static List<List<Integer>> list;
    static int[][] dp;

    private static void dfs(int idx, int parent) {
        dp[idx][0] = 0;
        dp[idx][1] = inhabits[idx];

        for (Integer child : list.get(idx)) {
            if (child != parent) {
                dfs(child, idx);
                dp[idx][0] += Math.max(dp[child][0], dp[child][1]);
                dp[idx][1] += dp[child][0];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inhabits = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inhabits[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dp = new int[n + 1][2];
        dfs(1, 0);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
}
