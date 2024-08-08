import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] trains;
    static int[] sum;
    static int m;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        trains = new int[n + 1];
        sum = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            trains[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + trains[i];
        }
        m = Integer.parseInt(br.readLine());
        dp = new int[4][n + 1];

        //2. 소형 기관차
        for (int i = 1; i <= 3; i++) {
            for (int j = i * m; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - m] + sum[j] - sum[j - m]);
            }
        }

        //3. 정답 출력
        System.out.println(dp[3][n]);
    }
}
