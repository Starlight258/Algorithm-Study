import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[3] = 1;
        if (n >= 5) {
            dp[5] = 1;
        }
        for (int i = 6; i <= n; i++) {
            if (dp[i - 3] != -1) {
                dp[i] = dp[i - 3] + 1;
            }
            if (dp[i - 5] != -1) {
                dp[i] = dp[i - 5] + 1;
            }
        }

        System.out.println(dp[n]);
    }

}
