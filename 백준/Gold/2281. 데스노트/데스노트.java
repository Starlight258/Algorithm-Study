import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] names;
    static int[] dp;

    private static int dfs(int index) {
        // 남은 칸수가 존재하는 값
        if (dp[index] < Integer.MAX_VALUE) {
            return dp[index];
        }

        int k = m - names[index]; // 남은 칸 수
        for (int i = index + 1; i <= n && k >= 0; i++) {
            if (i == n) { // 한 줄이 다 채워진 경우
                dp[index] = 0;
                break;
            }
            // 이어붙인 경우와 이어붙이지 않은 경우
            dp[index] = Math.min(dp[index], (k * k) + dfs(i));
            k -= names[i] + 1;
        }
        return dp[index];
    }

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        names = new int[n];
        for (int i = 0; i < n; i++) {
            names[i] = Integer.parseInt(br.readLine());
        }
        //2. dp 수행하기
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        System.out.println(dfs(0));
    }
}
