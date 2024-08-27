import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int[] files = new int[k + 1];
            int[] prefix = new int[k + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                prefix[i] = prefix[i - 1] + files[i];
            }

            int[][] dp = new int[k + 1][k + 1]; // i부터 j까지 중간합 최소값
            for (int i = 1; i < k; i++) { // 더할 개수
                for (int j = 1; j <= k - i; j++) { // 시작 위치
                    int end = j + i;
                    dp[j][end] = Integer.MAX_VALUE;
                    for (int l = j; l < end; l++) { // 나눌 위치(끝 제외)
                        dp[j][end] = Math.min(dp[j][end],
                                dp[j][l] + dp[l + 1][end] + prefix[end] - prefix[j - 1]);
                    }
                }
            }
            System.out.println(dp[1][k]);
        }
    }
}
