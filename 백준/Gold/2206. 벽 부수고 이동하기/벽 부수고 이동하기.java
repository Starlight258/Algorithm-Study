import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][][] visited;
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bssfs());
    }

    private static int bssfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int y = poll[0];
                int x = poll[1];
                int count = poll[2];
                if (y == n - 1 && x == m - 1) {
                    return distance;
                }

                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if (visited[ny][nx][count]) {
                        continue;
                    }
                    visited[ny][nx][count] = true;
                    if (map[ny][nx] == 1) {
                        if (count == 1) {
                            continue;
                        }
                        queue.offer(new int[]{ny, nx, 1});
                    } else {
                        queue.offer(new int[]{ny, nx, count});
                    }
                }
            }
        }
        return -1;
    }

}
