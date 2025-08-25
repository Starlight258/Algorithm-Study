import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    private static int n;
    private static int m;
    private static int answer;
    private static int[][] map;
    //    1
    // -1   1
    //   -1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int ry = Integer.parseInt(st.nextToken());
        int rx = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        moveRobots(ry, rx, d);
        System.out.println(answer);
    }

    private static void moveRobots(int ry, int rx, int d) {
        while (true) {
            if (map[ry][rx] == 0) {
                map[ry][rx] = 2;
                answer++;
            }
            boolean isDirty = false;
            for (int i = 0; i < 4; i++) {
                int ny = ry + dy[i];
                int nx = rx + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (map[ny][nx] == 0) {
                    isDirty = true;
                    break;
                }
            }
            if (!isDirty) {
                int nd = (d + 2) % 4;
                ry = ry + dy[nd];
                rx = rx + dx[nd];
                if (ry < 0 || rx < 0 || ry >= n || rx >= m) {
                    break;
                }
                if (map[ry][rx] == 1) {
                    break;
                }
                continue;
            }
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int ny = ry + dy[d];
                int nx = rx + dx[d];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (map[ny][nx] == 0) {
                    ry = ny;
                    rx = nx;
                    break;
                }
            }
        }
    }

}
