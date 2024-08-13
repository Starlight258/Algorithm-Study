import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] nums;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[n][n]; // i부터 j까지 팰린드롬 여부
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

        // 글자 3개
        for (int count = 2; count < n; count++) { // 비교할 갯수
            for (int from = 0; from + count < n; from++) { // 시작 위치
                int to = from + count;
                if (dp[from + 1][to - 1] && (nums[from] == nums[to])) {
                    dp[from][to] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
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
