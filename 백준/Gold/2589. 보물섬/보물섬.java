import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static int max = 0;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int y, int x) {
        int[][] visited = new int[n][m];
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{y, x});
        visited[y][x] = 1;

        while (!queue.isEmpty()) {
            Integer[] cur = queue.poll();
            y = cur[0];
            x = cur[1];
            max = Math.max(max, visited[y][x]);

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] != 0 || map[ny][nx] == 'W') {
                    continue;
                }

                visited[ny][nx] = visited[y][x] + 1;
                queue.add(new Integer[]{ny, nx});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m]; // W: 0, L: 1

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(max - 1);
    }
}
