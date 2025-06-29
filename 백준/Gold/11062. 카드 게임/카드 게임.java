import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dp;
    private static int[] arr, prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            dp = new int[n][n];
            prefix = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                prefix[i + 1] = prefix[i] + arr[i];
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }

            System.out.println(solved(0, n - 1));
        }
    }

    private static int solved(final int i, final int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int total = prefix[j + 1] - prefix[i]; // i~j 전체합
        int left = solved(i + 1, j); // 상대방 arr[i]
        int right = solved(i, j - 1); //상대가 arr[j] 가져감

        return dp[i][j] = total - Math.min(left, right);
    }
}
