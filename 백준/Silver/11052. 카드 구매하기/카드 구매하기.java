import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // N장의 카드 만들 수 있는 경우의 수 중에서 -> 금액의 최대값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < cards.length; i++) {
            dp[i + 1] = cards[i];
        }
        // dp[i] = 카드 i개를 만들 수 있는 금액 최대값 , 상향식
        for (int amount = 1; amount <= n; amount++) {
            for (int j = 0; j < cards.length; j++) {
                int money = cards[j];
                int cardCount = j + 1;
                if (amount > cardCount && dp[amount - cardCount] != -1) {
                    dp[amount] = Math.max(dp[amount], dp[amount - cardCount] + money);
                }
            }
        }
        System.out.println(dp[n]);
    }

}
