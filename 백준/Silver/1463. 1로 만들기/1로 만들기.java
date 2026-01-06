import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

    X가 3으로 나누어 떨어지면, 3으로 나눈다.
    X가 2로 나누어 떨어지면, 2로 나눈다.
    1을 뺀다.
    정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
     */

    /*
    X/3, X/2, X-1
    dp[1] = 0;
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 1_000_000;
        int[] dp = new int[max + 1];
        dp[1] = 0;
        for (int x = 2; x <= n; x++) {
            dp[x] = dp[x - 1] + 1;
            if (x % 2 == 0) {
                dp[x] = Math.min(dp[x], dp[x / 2] + 1);
            }
            if (x % 3 == 0) {
                dp[x] = Math.min(dp[x], dp[x / 3] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
