import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int max = c + 100;
        int[] dp = new int[max + 1];
        Arrays.fill(dp, 1_000_000_000);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for (int j = customer; j <= max; j++) {
                dp[j] = Math.min(dp[j], dp[j - customer] + cost);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = c; i <= max; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
    // 9원-> 3명
    // 18원 -> 6명
    // 27원 -> 9명
    // dp[9]=3;
    // dp[18]=6
    // dp[12] = dp[10] + dp[2]
}
