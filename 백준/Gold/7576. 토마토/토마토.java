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
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                boxes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfsse());
    }

    private static int bfsse() {
        int[][] visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (boxes[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

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
                if (boxes[ny][nx] == 0 & visited[ny][nx] == 0) {
                    boxes[ny][nx] = 1;
                    queue.offer(new int[]{ny, nx});
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (boxes[i][j] == 0) {
                    return -1;
                }
                answer = Math.max(answer, visited[i][j] - 1);
            }
        }
        return answer;

    }

}
