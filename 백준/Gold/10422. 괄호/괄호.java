import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        // dp 배열 만들기
        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 2; i < 2501; i++) {
            for (int j = 0; j < i; j++) {
                dp[i * 2] += dp[j * 2] * dp[(i - j - 1) * 2];
                dp[i * 2] %= 1_000_000_007L;
            }
        }

        while (t-- > 0) {
            int number = Integer.parseInt(br.readLine());
            System.out.println(dp[number]);
        }
    }
}
