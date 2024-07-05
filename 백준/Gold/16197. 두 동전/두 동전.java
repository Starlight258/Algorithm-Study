import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    static List<int[]> coins;
    static char[][] arr;
    static boolean[][][][] visited;

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{coins.get(0)[0], coins.get(0)[1], coins.get(1)[0], coins.get(1)[1], 0});
        while (!q.isEmpty()) {
            int y1 = q.peek()[0];
            int x1 = q.peek()[1];
            int y2 = q.peek()[2];
            int x2 = q.peek()[3];
            int cnt = q.peek()[4];
            q.poll();
            if (cnt >= 10) {
                return -1;
            }
            for (int i = 0; i < 4; i++) {
                int ny1 = y1 + dy[i];
                int nx1 = x1 + dx[i];
                int ny2 = y2 + dy[i];
                int nx2 = x2 + dx[i];
                boolean isFall1 = false;
                boolean isFall2 = false;
                if (ny1 < 0 || ny1 >= n || nx1 < 0 || nx1 >= m) {
                    isFall1 = true;
                }
                if (ny2 < 0 || ny2 >= n || nx2 < 0 || nx2 >= m) {
                    isFall2 = true;
                }
                if (isFall1 && isFall2) {
                    continue;
                } else if ((!isFall1 && isFall2) || (isFall1 && !isFall2)) {
                    return cnt + 1;
                }
                if (arr[ny1][nx1] == '#') {
                    ny1 = y1;
                    nx1 = x1;
                }
                if (arr[ny2][nx2] == '#') {
                    ny2 = y2;
                    nx2 = x2;
                }
                if (visited[ny1][nx1][ny2][nx2]) {
                    continue;
                }
                q.add(new int[]{ny1, nx1, ny2, nx2, cnt + 1});
                visited[ny1][nx1][ny2][nx2] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m][n][m];
        coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = (char) br.read();
                if (arr[i][j] == 'o') {
                    coins.add(new int[]{i, j});
                }
            }
            br.readLine();
        }

        //2. bfs
        System.out.println(bfs());
    }
}
