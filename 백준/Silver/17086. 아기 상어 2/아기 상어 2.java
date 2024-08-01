import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] graph;
    static int[][] minWeight;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        q.add(new int[]{y, x});
        visited[y][x] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            y = cur[0];
            x = cur[1];
            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[y][x] + 1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                minWeight[i][j] = Math.min(minWeight[i][j], visited[i][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minWeight = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minWeight[i], 51);
        }

        //2. bfs 수행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        //3. 안전거리 최댓값 출력
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(minWeight[i][j], answer);
            }
        }
        System.out.println(answer - 1);
    }
}
