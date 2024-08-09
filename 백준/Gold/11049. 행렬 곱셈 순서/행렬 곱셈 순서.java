import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] data = new int[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            data[i] = r;
            data[i + 1] = c;
        }

        int[][] dp = new int[n][n];

        for (int i = 2; i <= n; i++) { // 곱할 행렬 개수
            for (int j = 0; j <= n - i; j++) { // 구간 시작점
                dp[j][j + i - 1] = Integer.MAX_VALUE;
                for (int k = j; k < j + i - 1; k++) { // 나눌 지점
                    int value = dp[j][k] + dp[k + 1][j + i - 1] + (data[j] * data[k + 1] * data[j + i]);
                    dp[j][j + i - 1] = Math.min(dp[j][j + i - 1], value);
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
