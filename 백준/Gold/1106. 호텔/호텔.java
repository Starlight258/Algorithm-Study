import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] cities = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            cities[i] = new int[]{cost, number};
        }

        int max = c + 100;
        int INF= 1_000_000_000;
        int[] minCost = new int[max+1];
        Arrays.fill(minCost, INF);
        minCost[0] = 0;
        for (int[] city : cities) {
            int cost = city[0];
            int number = city[1];
            for (int i = number; i <= max; i += 1) {
                minCost[i] = Math.min(minCost[i], minCost[i - number] + cost);
            }
        }
        int answer = INF;
        for (int i = c; i <= max; i++) {
            answer = Math.min(answer, minCost[i]);
        }
        System.out.println(answer);
    }
    // 9원 -> 3명의 고객이 늘어난다.
    // 18원 -> 6명의 고객
    // 27원 -> 9명의 고객
    // 9의 정수배만큼 고객이 늘어난다.
    // 12 -> 5 * 2 + 1 * 2
    // dp[i] = k : k명일때 최소 비용
}
