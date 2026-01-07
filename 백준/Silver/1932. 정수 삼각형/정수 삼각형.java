import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
    맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
    삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

      7(0,0)
      3(1,0)  8(1,1)
      8(2,0)  1(2,1)  0(2,2)
      2(3,0)  7(3,1)  4(3,2)  4(3,3)
      4   5   2   6   5
     */
    /*
    dp[i][j] : i행 j열에 있는 최대값
    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + s[i][j]
    1<=j<=n-1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n]; // 정답: dp[n-1][0~n-1]
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }
        System.out.println(answer);
    }
}
