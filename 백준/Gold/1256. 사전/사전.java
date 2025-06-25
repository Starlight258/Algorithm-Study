import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static long[][] dp = new long[201][201]; // nCr = n-1Cr-1 + n-1Cr
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 200; i++) {
            dp[i][0] = dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1] + dp[i - 1][j], 1_000_000_001L); // overflow 방지
            }
        }

        if (dp[N + M][N] < K) { // 전체 가능한 문자열 수와 k 비교
            System.out.println(-1);
        } else {
            build(N, M, K);
            System.out.println(sb.toString());
        }
    }

    private static void build(int n, int m, final int k) {
        if (n == 0) {
            while (m-- > 0) {
                sb.append('z');
            }
            return;
        }
        if (m == 0) {
            while (n-- > 0) {
                sb.append('a');
            }
            return;
        }

        long left = dp[n + m - 1][n - 1]; // a를 맨 앞에 둘 경우 경우의 수
        if (k <= left) { // 경우의 수 존재
            sb.append('a');
            build(n - 1, m, k);
        } else {
            sb.append('z');
            build(n, m - 1, k - (int) left); // 나머지 수 관해서 경우의 수 구하기
        }
    }

}
