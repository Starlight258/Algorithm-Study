import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        boolean[][] dp = new boolean[n][n]; // i부터 j까지 팰린드롬인지 여부

        // 글자 1개
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 글자 2개
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                dp[i][i + 1] = true;
            }

        }

        // 글자 3개 이상
        for (int i = 2; i < n; i++) { // 더할 개수
            for (int j = 0; j + i < n; j++) { // 시작 위치
                int end = j + i;
                if (dp[j + 1][end - 1] && nums[j] == nums[end]) {
                    dp[j][end] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sb.append(dp[a][b] ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}
