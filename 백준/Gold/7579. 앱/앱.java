import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] bytes = new int[n];
        int[] cost = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bytes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int maxCost = 10000;
        int[] dp = new int[maxCost + 1]; // 비용으로 얻을 수 있는 최대 메모리 양
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) { // 인덱스
            for (int j = maxCost; j >= cost[i]; j--) {
                if (dp[j - cost[i]] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - cost[i]] + bytes[i]);
                }
            }
        }

        for (int i = 0; i <= maxCost; i++) {
            if (dp[i] >= m) {
                System.out.println(i);
                break;
            }
        }
    }
}
