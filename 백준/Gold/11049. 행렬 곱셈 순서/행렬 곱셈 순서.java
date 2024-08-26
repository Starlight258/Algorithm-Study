import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] matrix = new int[n + 1];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[i] = r;
            matrix[i + 1] = c;
        }

        int[][] dp = new int[n][n]; // i~j까지 곱셈 연산 최소값
        for (int i = 2; i <= n; i++) { // 곱할 행렬 개수
            for (int j = 0; j <= n - i; j++) { // 시작 위치
                dp[j][i + j - 1] = Integer.MAX_VALUE;
                for (int k = j; k < i + j - 1; k++) { // 나눌 위치
                    int value = dp[j][k] + dp[k + 1][j + i - 1] + (matrix[j] * matrix[k + 1] * matrix[j + i]);
                    dp[j][i + j - 1] = Math.min(dp[j][j + i - 1], value);
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
