import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] prefix;
    static int m;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        prefix = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        dp = new int[4][n + 1]; // 1~3대 소형차 인덱스, trains 인덱스
        for (int i = 1; i <= 3; i++) { // 소형차
            for (int j = m * i; j <= n; j++) { // 끝 인덱스
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - m] + prefix[j] - prefix[j - m]);
            }
        }
        System.out.println(dp[3][n]);
    }
}
