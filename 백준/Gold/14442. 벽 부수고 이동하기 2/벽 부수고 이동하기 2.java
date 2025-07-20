import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static int[][] map;
    static int[][][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Node {
        int y, x, broken;

        Node(int y, int x, int broken) {
            this.y = y;
            this.x = x;
            this.broken = broken;
        }
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                if (map[ny][nx] == 0 && visited[ny][nx][node.broken] == 0) {
                    visited[ny][nx][node.broken] = visited[node.y][node.x][node.broken] + 1;
                    queue.add(new Node(ny, nx, node.broken));
                }

                if (map[ny][nx] == 1 && node.broken < k && visited[ny][nx][node.broken + 1] == 0) {
                    visited[ny][nx][node.broken + 1] = visited[node.y][node.x][node.broken] + 1;
                    queue.add(new Node(ny, nx, node.broken + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            int val = visited[n - 1][m - 1][i];
            if (val != 0) {
                answer = Math.min(answer, val);
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
