import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    private static int[][] boxes;
    private static int m;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        boxes = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                boxes[i][j] = Integer.parseInt(st.nextToken());
                if (boxes[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs(queue));
    }

    private static int bfs(final Queue<int[]> queue) {
        int[][] visited = new int[n][m];
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (boxes[ny][nx] == 0) {
                    queue.offer(new int[]{ny, nx});
                    boxes[ny][nx] = boxes[y][x] + 1;
                    answer = Math.max(answer, boxes[ny][nx] - 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (boxes[i][j] == 0) {
                    return -1;
                }
            }
        }
        return answer;
    }

}
