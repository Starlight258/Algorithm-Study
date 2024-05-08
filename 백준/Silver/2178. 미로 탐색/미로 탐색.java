import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static void bfs(int n, int m) {
        visited[0][0] = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int y = currentNode.y;
            int x = currentNode.x;
            if (y == n && x == m) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }
                if (visited[ny][nx] == 0 && map[ny][nx]) {
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.offer(new Node(ny, nx));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        map = new boolean[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) != '0';
            }
        }

        //2. bfs 수행
        bfs(n, m);

        //3. 정답 출력
        System.out.println(visited[n - 1][m - 1]);

    }
}
