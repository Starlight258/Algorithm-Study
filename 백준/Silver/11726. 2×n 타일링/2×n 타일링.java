import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
    아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
    n=1(세로) : 1
    n=2 : 1+ 1, 2+ 0
    n=3 : 1+ 1+1, 1+2, 2 +1
    n=4 : dp[3] 1+ 1+1+1, 1+ 1+2, 1+ 2+1
    dp[2] 2+ 1+1, 2+2
    3+ 1
    dp[n] = dp[n-1] + dp[n-2]
    dp[1] = 1
    dp[2] = 2
    dp[3] = dp[2] + dp[1] = 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 1001;
        int[] dp = new int[max];
        dp[1] = 1;
        dp[2] = 2;
        int mod = 10_007;
        for (int i = 3; i <= n; i++) {
            dp[i] += dp[i - 1] % mod;
            dp[i] += dp[i - 2] % mod;
        }
        System.out.println(dp[n] % mod);
    }

}
