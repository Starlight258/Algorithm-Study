import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        // 증가하는 부분 수열
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 감소하는 부분 수열
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        // 두 배열의 합 중 최대값 - 1
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i] + dp2[i]);
        }

        System.out.println(answer - 1);
    }
}
