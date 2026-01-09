import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
    아래 그림은 2×17 직사각형을 채운 한가지 예이다.
     */
    /*
    2 = 2(2가지), 1+1
    dp[2] = 3

    3= 2+1, 1+1+1
    dp[3] = dp[3-2], dp[3-1]
    dp[4] = 2 * dp[4-2], dp[4-1]
    dp[5] = dp[4], dp[3]*2,
    dp[i] = dp[i-1] + dp[i-2] * 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] += dp[i - 1] % 10_007;
            dp[i] += dp[i - 2] * 2 % 10_007;
        }
        System.out.println(dp[n] % 10_007);
    }
}
