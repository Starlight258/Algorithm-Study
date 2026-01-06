import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

    1+ 1+1+1
    1+ 1+2
    1+ 2+1
    1+ 3
    2+ 1+1
    2+ 2
    3+ 1
    정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
    dp[n] = dp[n] + dp[n-i]
    dp[1] = 1
    dp[2] = 2
    1+1
    2
    dp[3] = 4
    1+2
    1+1+1
    2+1
    3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int max = 12;
        int[] dp = new int[max];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int x = 4; x < max; x++) {
            for (int i = 1; i <= 3; i++) {
                dp[x] += dp[x - i];
            }
        }
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }

}
