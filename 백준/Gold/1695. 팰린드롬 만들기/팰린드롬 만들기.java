import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        System.out.println(solve(0, n - 1, dp, numbers));
    }

    private static int solve(final int i, final int j, final int[][] dp, final int[] numbers) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != INF) {
            return dp[i][j];
        }
        if (numbers[i] == numbers[j]) {
            return dp[i][j] = solve(i + 1, j - 1, dp, numbers);
        }
        return dp[i][j] = Math.min(solve(i + 1, j, dp, numbers), solve(i, j - 1, dp, numbers)) + 1;
    }

}
