import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final String FAIL = "Fail";
    private static int n, m, t;
    private static int[][] board;
    private static boolean[][][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(st.nextToken()));
            }
        }

        visited = new boolean[n][m][2];
        int result = bfs(0, 0);
        if (result == -1) {
            System.out.println(FAIL);
        } else {
            System.out.println(result);
        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0, false));
        visited[x][y][0] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.count > t) {
                break;
            }
            if (current.x == n - 1 && current.y == m - 1) {
                return current.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!current.isGram) { //그람 없음
                        if (!visited[nx][ny][0] && board[nx][ny] == 0) {
                            q.offer(new Node(nx, ny, current.count + 1, current.isGram));
                            visited[nx][ny][0] = true;
                        } else if (!visited[nx][ny][0] && board[nx][ny] == 2) {
                            q.offer(new Node(nx, ny, current.count + 1, true));
                            visited[nx][ny][0] = true;
                        }
                    } else { //그람 있음
                        if (!visited[nx][ny][1]) {
                            q.offer(new Node(nx, ny, current.count + 1, current.isGram));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static class Node {
        int x;
        int y;
        int count;
        boolean isGram;

        public Node(int x, int y, int count, boolean isGram) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isGram = isGram;
        }
    }
}
