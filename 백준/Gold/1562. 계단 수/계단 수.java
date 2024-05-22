import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //2. dp + 비트마스킹
        int[][][] dp = new int[n + 1][10][1 << 10];

        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int num = 2; num < n + 1; num++) { // 자리수
            for (int endNum = 0; endNum < 10; endNum++) { // 끝나는 수
                for (int k = 0; k < (1 << 10); k++) { // 사용한 숫자
                    int bit = k | (1 << endNum);
                    if (endNum == 0) {
                        dp[num][endNum][bit] = (dp[num][endNum][k] + dp[num - 1][endNum + 1][k]) % MOD;
                    } else if (endNum == 9) {
                        dp[num][endNum][bit] = (dp[num][endNum][k] + dp[num - 1][endNum - 1][k]) % MOD;
                    } else {
                        dp[num][endNum][bit] =
                                (dp[num][endNum][bit] + dp[num - 1][endNum + 1][k] + dp[num - 1][endNum - 1][k])
                                        % MOD;
                    }
                }
            }
        }

        //3. 정답 출력
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[n][i][(1 << 10) - 1]) % MOD;
        }
        System.out.println(result);
    }
}
