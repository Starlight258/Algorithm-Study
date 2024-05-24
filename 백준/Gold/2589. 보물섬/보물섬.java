import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static List<Integer[]> land = new ArrayList<>();
    static int max = 0;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] visited;

    static void bfs(int y, int x) {
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

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (visited[ny][nx] != 0) {
                    continue;
                }
                if (map[ny][nx] == 0) {
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
        map = new int[n][m]; // W: 0, L: 1

        String line;
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'L') {
                    map[i][j] = 1;
                    land.add(new Integer[]{i, j});
                } else {
                    map[i][j] = 0;
                }
            }
        }

        visited = new int[n][m];
        max = 0;

        for (Integer[] integers : land) {
            Arrays.stream(visited)
                    .forEach(arr -> Arrays.fill(arr, 0));
            bfs(integers[0], integers[1]);
        }

        System.out.println(max - 1);
    }
}
