import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
    준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

    동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
     */
    /*
    dp[i] = i원을 만들 수 있는 동전 개수의 최솟값
    10 4200
    1
    5
    10
    50
    100
    500
    1000
    5000
    10000
    50000
    dp[0] = 0
    dp[1] = 1;
    dp[2] = dp[2-1] + 1 = 2;
    dp[3] = dp[3-1] + 1 = 3;
    dp[4] = dp[4-1] + 1 = 4;
    dp[5] = dp[5-1] + 1 = 5
     = dp[5-5] + 1 = 1
    dp[10] = dp[9] + 1 or dp[5] + 1 or dp[0] + 1 -> 1
    dp[i] = dp[i-동전 금액] + 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100_000_001);
        dp[0] = 0;
        for (int i = coins[0]; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                int coin = coins[j];
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        System.out.println(dp[k]);
    }
}
