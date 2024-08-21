import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] nums;
    static long[][] dp;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp = new long[n][21];

        dp[0][nums[0]] = 1;

        for (int i = 1; i < n - 1; i++) { // 인덱스
            for (int j = 0; j <= 20; j++) { // 합
                if (dp[i - 1][j] == 0) {
                    continue;
                }
                int plus = j + nums[i];
                int minus = j - nums[i];
                if (plus >= 0 && plus <= 20) {
                    dp[i][plus] += dp[i - 1][j];
                }
                if (minus >= 0 && minus <= 20) {
                    dp[i][minus] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n - 2][nums[n - 1]]);
    }
}
