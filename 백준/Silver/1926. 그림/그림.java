import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라.
    단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자.
    가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다.
    그림의 넓이란 그림에 포함된 1의 개수이다.
     */
    /*
    6(n) 5(m)
    1 1 0 1 1
    0 1 1 0 0
    0 0 0 0 0
    1 0 1 1 1
    0 0 1 1 1
    0 0 1 1 1
    bfs : 그림의 개수, 가장 큰 넓이 출력
     */
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] draws = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                draws[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && draws[i][j] == 1) {
                    count++;
                    int area = bfs(n, m, visited, draws, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }

    private static int bfs(final int n, final int m,
                            final boolean[][] visited, final int[][] draws, int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        int area = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            y = cur[0];
            x = cur[1];
            area++;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (visited[ny][nx] || draws[ny][nx] == 0) {
                    continue;
                }
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
            }
        }
        return area;
    }

}
