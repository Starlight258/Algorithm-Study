import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //2. dp 수행
        dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i > 6) {
                for (int j = 3; j < 6; j++) { // 3번까지는 붙여넣기
                    dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
                }
            }
        }
        //3. 정답 출력
        System.out.println(dp[n]);
    }
}
