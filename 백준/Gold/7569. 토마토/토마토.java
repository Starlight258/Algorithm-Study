import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int M, N, H;
    static int[][][] box;
    static int[][][] dist;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        box = new int[H][N][M];
        dist = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = sc.nextInt();
                    if (box[h][n][m] == 1) {
                        q.add(new int[]{h, n, m});
                    }
                    if (box[h][n][m] == 0) {
                        dist[h][n][m] = -1;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0], x = cur[1], y = cur[2];

            for (int dir = 0; dir < 6; dir++) {
                int nz = z + dz[dir];
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nz < 0 || nz >= H || nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (dist[nz][nx][ny] != -1) {
                    continue;
                }
                dist[nz][nx][ny] = dist[z][x][y] + 1;
                q.add(new int[]{nz, nx, ny});
            }
        }

        int answer = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (dist[h][n][m] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, dist[h][n][m]);
                }
            }
        }

        System.out.println(answer);
    }
}
