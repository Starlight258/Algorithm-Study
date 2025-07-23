import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dy = {2, 2, 1, -1, -2, -2, -1, 1};
    private static int[] dx = {1, -1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int cy = Integer.parseInt(st.nextToken());
            int cx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ty = Integer.parseInt(st.nextToken());
            int tx = Integer.parseInt(st.nextToken());
            knightRun(n, cy, cx, ty, tx);
        }
    }

    private static void knightRun(final int n, final int cy, final int cx, final int ty, final int tx) {
        int[][] visited = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{cy, cx});
        visited[cy][cx] = 1;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int y = node[0];
            int x = node[1];
            if (y == ty && x == tx) {
                System.out.println(visited[ty][tx] - 1);
                break;
            }

            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if (visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

}
