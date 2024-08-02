import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] graph;
    static long[][] dp;

    private static void jump() {
        dp[0][0] = 1;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (dp[y][x] == 0 || graph[y][x] == 0) {
                    continue;
                }

                int next = graph[y][x];
                // ->
                if (x + next < n) {
                    dp[y][x + next] += dp[y][x];
                }
                // 아래
                if (y + next < n) {
                    dp[y + next][x] += dp[y][x];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2. dp 수행
        dp = new long[n][n];
        jump();

        //3. 정답 출력
        System.out.println(dp[n - 1][n - 1]);
    }
}
