import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 2. dp 배열 만들기
        int[] cases = new int[]{1, 2, 3};
        int[] dp = new int[10001];
        dp[0] = 1;
        for (int i = 0; i < cases.length; i++) {
            for (int j = cases[0]; j <= 10000; j++) {
                if (j - cases[i] >= 0) {
                    dp[j] += dp[j - cases[i]];
                }
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
