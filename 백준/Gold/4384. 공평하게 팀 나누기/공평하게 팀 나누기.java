import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    학생회장을 하고 있는 상근이는 이번 학교 축제 행사로 학우들간의 친밀감을 돈독히 하고자 줄다리기를 하려 한다.
    하지만 이 줄다리기에 형평성을 최대한 고려하기위해 두 팀간의 사람 수 차이를 1 이하로 하려하며, 두 팀간의 몸무게의 차이가 최소화되도록 하고자 한다.
    이때 상근이가 나누려 하는 두 팀의 몸무게를 각각 출력 하시오.
     */

    /*
    boolean dp[명][무게] = j명으로 k무게를 만들 수 있는지
    N/2, N/2+1명
    dp[j][k] = dp[j][k] || dp[j-1][k-weights[i]]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(br.readLine());
            total += w[i];
        }
        boolean[][] dp = new boolean[n][total + 1];
        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = n / 2; j > 0; j--) {
                for (int k = total; k >= w[i]; k--) {
                    dp[j][k] = dp[j][k] || dp[j - 1][k - w[i]];
                }
            }
        }
        int minDiff = Integer.MAX_VALUE;
        int team1weight = 0;
        for (int k = 0; k <= total; k++) {
            if (dp[n / 2][k]) {
                int b = total - k;
                int curDiff = Math.abs(k - b);
                if (minDiff > curDiff) {
                    minDiff = curDiff;
                    team1weight = k;
                }
            }
        }
        int team2weight = total - team1weight;

        if (team1weight > team2weight) {
            int temp = team1weight;
            team1weight = team2weight;
            team2weight = temp;
        }

        System.out.println(team1weight + " " + team2weight);
    }

}
