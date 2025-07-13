import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {1, -1, 0, 0, 0, 0};
    private static final int[] dx = {0, 0, 1, -1, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, 1, -1};

    private static int M;
    private static int N;
    private static int H;
    private static int[][][] tomato;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[N][M][H];
        visited = new boolean[N][M][H];
        Queue<int[]> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomato[n][m][h] = Integer.parseInt(st.nextToken());
                    if (tomato[n][m][h] == 1) {
                        queue.offer(new int[]{h, n, m});
                        visited[n][m][h] = true;
                    }
                }
            }
        }

        int days = bfs(queue);
        if (isAllRipe()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean isAllRipe() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (tomato[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int bfs(final Queue<int[]> queue) {
        int day = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int d = 0; d < 6; d++) {
                    int nh = cur[0] + dz[d];
                    int ny = cur[1] + dy[d];
                    int nx = cur[2] + dx[d];

                    if (nh < 0 || ny < 0 || nx < 0 || nh >= H || ny >= N || nx >= M) {
                        continue;
                    }
                    if (tomato[ny][nx][nh] == 0 && !visited[ny][nx][nh]) {
                        visited[ny][nx][nh] = true;
                        tomato[ny][nx][nh] = 1;
                        queue.offer(new int[]{nh, ny, nx});
                    }
                }
            }
            day++;
        }
        return day;
    }
}
