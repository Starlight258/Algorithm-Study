import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};
    private static int n;
    private static int m;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        // dfs 수행
        boolean isExists = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isExists = dfs(new int[]{i, j}, i, j, new boolean[n][m], 0);
                if (isExists) {
                    break;
                }
            }
            if (isExists) {
                break;
            }
        }
        System.out.println(isExists ? "Yes" : "No");
    }

    private static boolean dfs(int[] start, int y, int x, boolean[][] visited, int length) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue;
            }
            if (ny == start[0] && nx == start[1] && length >= 3) {
                return true;
            }
            if (visited[ny][nx] || map[y][x] != map[ny][nx]) {
                continue;
            }
            if (dfs(start, ny, nx, visited, length + 1)) {
                return true;
            }
        }
        return false;
    }
}
