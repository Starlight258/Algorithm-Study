import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
    보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
    하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
    대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
    철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

    토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
    며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
    단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
     */
    /*
    6 4
    0 0 0 0 0 0
    0 0 0 0 0 0
    0 0 0 0 0 0
    0 0 0 0 0 1
    토마토 모두 익는 최소 일자 : bfs
     */
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    private static int m;
    private static int n;
    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int day = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            day++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int y = cur[0];
                int x = cur[1];
                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if (visited[ny][nx] || board[ny][nx] != 0) {
                        continue;
                    }
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
        if (!hasRoten()) {
            System.out.println(-1);
        } else {
            System.out.println(day - 1);
        }
    }

    private static boolean hasRoten() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
