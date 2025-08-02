import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[][] maps;
    private static List<int[]> areas;
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maps = new int[n][m];
        areas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 0) {
                    areas.add(new int[]{i, j});
                }
            }
        }

        int size = areas.size();
        for (int i = 0; i < size; i++) {
            int[] node = areas.get(i);
            maps[node[0]][node[1]] = 1;
            for (int j = i + 1; j < size; j++) {
                int[] jNode = areas.get(j);
                maps[jNode[0]][jNode[1]] = 1;
                for (int k = j + 1; k < size; k++) {
                    int[] kNode = areas.get(k);
                    maps[kNode[0]][kNode[1]] = 1;
                    bfs();
                    maps[kNode[0]][kNode[1]] = 0;
                }
                maps[jNode[0]][jNode[1]] = 0;
            }
            maps[node[0]][node[1]] = 0;
        }
        System.out.println(answer);
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
        boolean[][] visited = new boolean[n][m];
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
                    visited[ny][nx] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }
}
