import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static char[][] map;

    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        int startY = 0, startX = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0') {
                    startY = i;
                    startX = j;
                    map[i][j] = '.';
                }
            }
        }

        // bfs 수행
        bfs(startY, startX);
    }

    private static void bfs(int y, int x) {
        int[][][] visited = new int[n][m][64];
        int key = 0;
        visited[y][x][key] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x, key});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            y = cur[0];
            x = cur[1];
            key = cur[2];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nkey = key;
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (map[ny][nx] == '#' || visited[ny][nx][nkey] != 0) {
                    continue;
                }

                // 1(도착지이면) 종료
                if (map[ny][nx] == '1') {
                    System.out.println(visited[y][x][key]);
                    return;
                }
                // 키가 존재하면 키 추가하기
                else if (map[ny][nx] >= 'a' && map[ny][nx] <= 'f') {
                    nkey |= 1 << (map[ny][nx] - 'a');
                }
                // 문이면 키 존재하는지 확인 -> 존재하면 이동
                else if (map[ny][nx] >= 'A' && map[ny][nx] <= 'F') {
                    if ((key & (1 << (map[ny][nx] - 'A'))) == 0) {
                        continue;
                    }
                }

                q.offer(new int[]{ny, nx, nkey});
                visited[ny][nx][nkey] = visited[y][x][key] + 1;
            }
        }
        System.out.println(-1);
    }
}
