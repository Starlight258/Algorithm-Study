import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][][] dp;

    static boolean check(int y, int x, int d) {
        if (d == 0 || d == 2) { // 가로, 세로
            if (map[y][x] == 0) {
                return true;
            }
        } else if (d == 1) { // 대각선(근처가 빈칸이어야함)
            if (map[y][x] == 0 && map[y - 1][x] == 0 && map[y][x - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[24][24];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[24][24][3]; // y, x, 방향(0:가로, 1:세로, 2:대각선)
        dp[1][2][0] = 1; // 시작점
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 가로
                // 가로 -> 가로
                if (check(i, j + 1, 0)) {
                    dp[i][j + 1][0] += dp[i][j][0];
                }
                // 가로 -> 대각선
                if (check(i + 1, j + 1, 1)) {
                    dp[i + 1][j + 1][1] += dp[i][j][0];
                }

                // 세로
                // 세로 -> 세로
                if (check(i + 1, j, 2)) {
                    dp[i + 1][j][2] += dp[i][j][2];
                }
                // 세로 -> 대각선
                if (check(i + 1, j + 1, 1)) {
                    dp[i + 1][j + 1][1] += dp[i][j][2];
                }

                // 대각선
                // 대각선 -> 가로
                if (check(i, j + 1, 0)) {
                    dp[i][j + 1][0] += dp[i][j][1];
                }
                // 대각선 -> 세로
                if (check(i + 1, j, 2)) {
                    dp[i + 1][j][2] += dp[i][j][1];
                }
                // 대각선 -> 대각선
                if (check(i + 1, j + 1, 1)) {
                    dp[i + 1][j + 1][1] += dp[i][j][1];
                }
            }
        }

        // 정답 출력
        int ret = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        System.out.println(ret);
    }
}
