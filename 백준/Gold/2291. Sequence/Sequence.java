import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][][] dp = new int[11][221][221]; // [자리 수][합][최소 숫자]

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // DP 배열 초기화
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        // 기저값: 정확히 수열 다 찼고 합 맞으면 1개 존재
        for (int i = 1; i <= M; i++) {
            dp[N][M][i] = 1;
        }

        // 가능한 모든 수열 개수 계산
        countSequences(0, 0, 1);

        // K번째 수열 구성 및 출력
        constructSequence(0, 0, 1, K);
    }

    // 가능한 수열 개수 세는 함수
    static int countSequences(int depth, int sum, int minValue) {
        if (depth > N || sum > M) return 0;
        if (dp[depth][sum][minValue] != -1) return dp[depth][sum][minValue];

        int total = 0;
        for (int next = minValue; next <= M; next++) {
            total += countSequences(depth + 1, sum + next, next);
        }

        return dp[depth][sum][minValue] = total;
    }

    // K번째 수열 직접 구성하는 함수
    static void constructSequence(int depth, int sum, int minValue, int k) {
        if (depth == N) return;

        for (int next = minValue; next <= M; next++) {
            int count = dp[depth + 1][sum + next][next];
            if (count == -1) continue;

            if (k > count) {
                k -= count;
            } else {
                System.out.print(next + " ");
                constructSequence(depth + 1, sum + next, next, k);
                break;
            }
        }
    }
}
