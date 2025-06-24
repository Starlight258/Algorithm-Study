import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scores.add(Integer.parseInt(br.readLine()));
        }

        int answer = dp(n, scores);
        System.out.println(answer);
    }

    private static int dp(final int n, final List<Integer> scores) {
        if (n == 1) {
            return scores.get(0);
        }
        if (n == 2) {
            return scores.get(0) + scores.get(1);
        }
        int[] dp = new int[n];
        dp[0] = scores.get(0);
        dp[1] = scores.get(0) + scores.get(1);
        dp[2] = Math.max(scores.get(0) + scores.get(2), scores.get(1) + scores.get(2));

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(
                    dp[i - 2] + scores.get(i),
                    dp[i - 3] + scores.get(i - 1) + scores.get(i));
        }
        return dp[n - 1];
    }
}
