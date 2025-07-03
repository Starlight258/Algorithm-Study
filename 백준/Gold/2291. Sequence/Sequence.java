import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][][] dp = new int[11][221][221]; // [자리 수][합][이전 숫자]

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // DP 초기화: -1로 채우기
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        // 마지막 자리 도달한 경우: 수열 완성
        for (int i = 1; i <= M; i++) {
            dp[N][M][i] = 1;
        }

        go(0, 0, 1); // DP 채우기
        go2(0, 0, 1, K); // K번째 수열 출력
    }

    static int go(int len, int sum, int recent) {
        if (len > N || sum > M) return 0;
        if (dp[len][sum][recent] != -1) return dp[len][sum][recent];

        int res = 0;
        for (int i = recent; i <= M; i++) {
            res += go(len + 1, sum + i, i);
        }

        return dp[len][sum][recent] = res;
    }

    static void go2(int len, int sum, int recent, int left) {
        if (len == N) return;

        for (int i = recent; i <= M; i++) {
            if (dp[len + 1][sum + i][i] == -1) continue;

            if (left > dp[len + 1][sum + i][i]) {
                left -= dp[len + 1][sum + i][i];
                continue;
            }

            System.out.print(i + " ");
            go2(len + 1, sum + i, i, left);
            break;
        }
    }
}
