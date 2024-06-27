import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 2. 동전 저장하기
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        // 3. dp 수행
        int[] dp = new int[k + 1];
        dp[0] = 1;
        
        for (int i = 0; i < n; i++) { // 동전
            for (int j = 1; j <= k; j++) { // 돈
                if (coin[i] <= j) {
                    dp[j] += dp[j - coin[i]];
                }
            }
        }

        //4. 정답 출력
        System.out.println(dp[k]);
    }
}
