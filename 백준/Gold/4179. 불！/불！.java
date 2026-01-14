import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    지훈이는 미로에서 일을 한다. 지훈이를 미로에서 탈출하도록 도와주자!
    미로에서의 지훈이의 위치와 불이 붙은 위치를 감안해서 지훈이가 불에 타기전에 탈출할 수 있는지의 여부,
    그리고 얼마나 빨리 탈출할 수 있는지를 결정해야한다.
    지훈이와 불은 매 분마다 한칸씩 수평또는 수직으로(비스듬하게 이동하지 않는다) 이동한다.
    불은 각 지점에서 네 방향으로 확산된다.
    지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다.
    지훈이와 불은 벽이 있는 공간은 통과하지 못한다.
     */
    /*
    4 4
    ####
    #JF#
    #..#
    #..#

    답 : 3
    bfs : 지훈이 위치가 y=n-1또는 0, x=0또는 m-1이 되면 종료
    지훈 이동 -> 불 이동이지만 불 이동 -> 불 없는 곳으로 지훈 이동
     */
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        int[][] fireTime = new int[n][m];
        int[][] jTime = new int[n][m];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Arrays.fill(fireTime[i], INF);
            Arrays.fill(jTime[i], INF);
        }

        int jy = 0, jx = 0;
        Queue<int[]> fq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                board[i][j] = c;
                if (c == 'J') {
                    jy = i;
                    jx = j;
                    jTime[jy][jx] = 0;
                } else if (c == 'F') {
                    fireTime[i][j] = 0;
                    fq.offer(new int[]{i, j});
                }
            }
        }

        // 불 이동
        while (!fq.isEmpty()) {
            int[] cur = fq.poll();
            int y = cur[0], x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (board[ny][nx] == '#' || fireTime[ny][nx] != INF) {
                    continue;
                }
                fq.offer(new int[]{ny, nx});
                fireTime[ny][nx] = fireTime[y][x] + 1;
            }
        }

        // 지훈 이동
        Queue<int[]> jq = new ArrayDeque<>();
        jq.offer(new int[]{jy, jx});
        while (!jq.isEmpty()) {
            int[] curJ = jq.poll();
            jy = curJ[0];
            jx = curJ[1];
            int t = jTime[jy][jx];
            // 지훈 이동
            for (int i = 0; i < 4; i++) {
                int njy = jy + dy[i];
                int njx = jx + dx[i];
                if (njy < 0 || njx < 0 || njy >= n || njx >= m) {
                    System.out.println(t + 1);
                    return;
                }
                if (jTime[njy][njx] != INF || board[njy][njx] == '#') {
                    continue;
                }
                int now = t + 1;
                if (fireTime[njy][njx] <= now) {
                    continue;
                }
                jq.offer(new int[]{njy, njx});
                jTime[njy][njx] = now;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
