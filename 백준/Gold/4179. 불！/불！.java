import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
        int[][] board = new int[n][m];
        boolean[][] fvisited = new boolean[n][m];
        boolean[][] jvisited = new boolean[n][m];
        int jy = 0, jx = 0;

        Queue<int[]> fq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == '#') {
                    board[i][j] = -1;
                } else if (c == '.') {
                    board[i][j] = 0;
                } else if (c == 'J') {
                    board[i][j] = 0;
                    jy = i;
                    jx = j;
                } else if (c == 'F') {
                    board[i][j] = 0;
                    fq.offer(new int[]{i, j});
                    fvisited[i][j] = true;
                }
            }
        }

        boolean canExit = false;

        Queue<int[]> jq = new ArrayDeque<>();
        jq.offer(new int[]{jy, jx});
        jvisited[jy][jx] = true;
        int time = 0;
        if (isEdge(jy, n, jx, m)) {
            System.out.println(1);
            return;
        }

        while (true) {
            // 불 이동
            int size = fq.size();
            while (size-- > 0) {
                int[] cur = fq.poll();
                int y = cur[0];
                int x = cur[1];
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if (fvisited[ny][nx] || board[ny][nx] == -1) {
                        continue;
                    }
                    fvisited[ny][nx] = true;
                    fq.offer(new int[]{ny, nx});
                }
            }

            if (jq.isEmpty()) {
                break;
            }
            size = jq.size();
            while (size-- > 0) {
                int[] curJ = jq.poll();
                jy = curJ[0];
                jx = curJ[1];
                // 지훈 이동
                for (int i = 0; i < 4; i++) {
                    int njy = jy + dy[i];
                    int njx = jx + dx[i];
                    if (njy < 0 || njx < 0 || njy >= n || njx >= m) {
                        continue;
                    }
                    if (fvisited[njy][njx] || jvisited[njy][njx] || board[njy][njx] == -1) {
                        continue;
                    }
                    if (isEdge(njy, n, njx, m)) {
                        canExit = true;
                        break;
                    }
                    jq.offer(new int[]{njy, njx});
                    jvisited[njy][njx] = true;
                }
                if (canExit) {
                    break;
                }
            }
            time++;
            if (canExit) {
                break;
            }
        }
        if (canExit) {
            System.out.println(time + 1);
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }

    private static boolean isEdge(final int y, final int n, final int x, final int m) {
        return y == 0 || y == n - 1 || x == 0 || x == m - 1;
    }

}
