import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int w;
    private static int h;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (!visited[y][x] && map[y][x] == 1) {
                        dfs(y, x);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(final int y, final int x) {
        visited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                continue;
            }
            if (!visited[ny][nx] && map[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }

}
