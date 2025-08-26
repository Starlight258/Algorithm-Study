import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                goAround(i, j, map[i][j], 1);
                visited[i][j] = false;
                checkMiddleTet(i, j);
            }
        }
        System.out.println(answer);
    }

    private static void goAround(final int y, final int x, final int sum, final int count) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            visited[ny][nx] = true;
            goAround(ny, nx, sum + map[ny][nx], count + 1);
            visited[ny][nx] = false;
        }
    }

    private static void checkMiddleTet(final int y, final int x) {
        if (y + 2 < n && x + 1 < m) {
            int total = map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1];
            answer = Math.max(answer, total);
        }
        if (y + 2 < n && x - 1 >= 0) {
            int total = map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1];
            answer = Math.max(answer, total);
        }
        if (x + 2 < m && y - 1 >= 0) {
            int total = map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1];
            answer = Math.max(answer, total);
        }
        if (x + 2 < m && y + 1 < n) {
            int total = map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1];
            answer = Math.max(answer, total);
        }
    }

}
