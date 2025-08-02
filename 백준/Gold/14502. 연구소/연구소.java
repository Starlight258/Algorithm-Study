import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    private static int n;
    private static int m;
    private static int[][] maps;
    private static List<int[]> emptySpaces;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maps = new int[n][m];
        emptySpaces = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                }
            }
        }

        buildWall(0, 0);
        System.out.println(answer);
    }

    public static void buildWall(int depth, int start) {
        if (depth == 3) {
            bfs();
            return;
        }
        for (int i = start; i < emptySpaces.size(); i++) {
            int[] space = emptySpaces.get(i);
            maps[space[0]][space[1]] = 1;
            buildWall(depth + 1, i + 1);
            maps[space[0]][space[1]] = 0;
        }
    }

    private static void bfs() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = maps[i][j];
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int y = node[0];
            int x = node[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (tmp[ny][nx] == 0) {
                    tmp[ny][nx] = 2;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }

        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) {
                    safe++;
                }
            }
        }
        answer = Math.max(answer, safe);
    }
}
