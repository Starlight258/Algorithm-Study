import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Node> tomato;

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        for (Node node : tomato) {
            queue.add(node);
            visited[node.y][node.x] = 1;
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curY = cur.y;
            int curX = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (ny < 0 || nx < 0 || ny >= m || nx >= n) {
                    continue;
                }
                if (visited[ny][nx] > 0 || map[ny][nx] == -1) {
                    continue;
                }

                visited[ny][nx] = visited[curY][curX] + 1;
                queue.add(new Node(ny, nx));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 가로
        m = Integer.parseInt(st.nextToken()); // 세로

        map = new int[m][n];
        visited = new int[m][n];
        int notTomato = 0;
        tomato = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    notTomato++;
                }
                if (map[i][j] == 1) {
                    tomato.add(new Node(i, j));
                }
            }
        }

        //2. bfs
        bfs();

        //3. 개수세기
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] > 0) {
                    cnt++;
                }
            }
        }

        //4. 결과 출력하기
        if (cnt == n * m - notTomato) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, visited[i][j]);
                }
            }
            System.out.println(max - 1);
        } else {
            System.out.println(-1);
        }
    }
}
