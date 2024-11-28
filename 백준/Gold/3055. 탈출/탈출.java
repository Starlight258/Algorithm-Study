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
    private static char[][] map;
    private static int[] urchin;
    private static int[] beaver;
    private static List<int[]> water;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        water = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    urchin = new int[]{i, j, 0};
                    map[i][j] = '.';
                }
                if (map[i][j] == 'D') {
                    beaver = new int[]{i, j};
                }
                if (map[i][j] == '*') {
                    water.add(new int[]{i, j});
                }
            }
        }
        // bfs
        int distance = bfs();
        System.out.println(distance == 0 ? "KAKTUS" : distance);
    }

    private static int bfs() {
        Queue<int[]> waterQ = new LinkedList<>();
        Queue<int[]> beaverQ = new LinkedList<>();

        beaverQ.add(urchin);
        for (int[] ints : water) {
            waterQ.offer(ints);
        }

        while (!beaverQ.isEmpty()) {
            // 물 이동
            int waterSize = waterQ.size();
            for (int count = 0; count < waterSize; count++) {
                int[] now = waterQ.poll();
                int y = now[0];
                int x = now[1];
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                        continue;
                    }
                    if (map[ny][nx] == '.') {
                        map[ny][nx] = '*';
                        waterQ.add(new int[]{ny, nx});
                    }
                }
            }

            // 비버 이동
            int beaverQSize = beaverQ.size();
            for (int count = 0; count < beaverQSize; count++) {
                int[] now = beaverQ.poll();
                int y = now[0];
                int x = now[1];
                int distance = now[2];
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                        continue;
                    }
                    if (map[ny][nx] == 'X' || map[ny][nx] == '*') {
                        continue;
                    }
                    if (map[ny][nx] == 'D') {
                        return distance + 1;
                    }
                    if (map[ny][nx] == '.') {
                        map[ny][nx] = 'S';
                        beaverQ.add(new int[]{ny, nx, distance + 1});
                    }
                }
            }
        }
        return 0;
    }
}
