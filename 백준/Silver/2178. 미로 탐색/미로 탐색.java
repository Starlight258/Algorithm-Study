import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final Queue<int[]> queue = new LinkedList<>();
    private static int[][] arr;
    private static int n;
    private static int m;
    private static int[][] visited;
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        arr = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        bfs();
    }

    private static void bfs() {
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];

            if (y == n - 1 && x == m - 1) {
                System.out.println(visited[n - 1][m - 1]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (visited[ny][nx] != 0 || arr[ny][nx] == 0) {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                visited[ny][nx] = visited[y][x] + 1;
            }
        }
    }
}
