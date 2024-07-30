import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] graph;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited;

    private static int dfs(int y, int x, int color) {
        int count = 1;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            if (!visited[ny][nx] && graph[ny][nx] == color) {
                count += dfs(ny, nx, color);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j);
            }
        }
        visited = new boolean[n][m];
        int[] answer = new int[2];

        // 2. dfs 수행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }
                int count = dfs(i, j, graph[i][j]);
                if (graph[i][j] == 'W') {
                    answer[0] += Math.pow(count, 2);
                } else {
                    answer[1] += Math.pow(count, 2);
                }
            }
        }

        // 3. answer
        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}
