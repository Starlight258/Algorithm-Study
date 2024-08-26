import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scvs = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scvs[i] = Integer.parseInt(st.nextToken());
        }
        int[][] attacks = {
                {9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}
        };
        boolean[][][] dp = new boolean[61][61][61];
        // bfs
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{scvs[0], scvs[1], scvs[2], 1});
        dp[scvs[0]][scvs[1]][scvs[2]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < attacks.length; i++) {
                int first = Math.max(cur[0] - attacks[i][0], 0);
                int second = Math.max(cur[1] - attacks[i][1], 0);
                int last = Math.max(cur[2] - attacks[i][2], 0);
                if (dp[first][second][last]) {
                    continue;
                }
                int depth = cur[3];
                if (first == 0 && second == 0 && last == 0) {
                    System.out.println(depth);
                    return;
                }
                q.offer(new int[]{first, second, last, depth + 1});
                dp[first][second][last] = true;
            }
        }
    }
}
