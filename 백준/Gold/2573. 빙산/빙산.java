import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2. 빙산 녹이기
        int year = 0;
        while (true) {
            year++;
            int[][] temp = new int[n][m];
            for (int i = 0; i < n; i++) {
                System.arraycopy(map[i], 0, temp[i], 0, m);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int ny = i + dy[k];
                            int nx = j + dx[k];
                            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                                continue;
                            }
                            if (map[ny][nx] == 0) {
                                cnt++;
                            }
                        }
                        temp[i][j] -= cnt;
                        if (temp[i][j] < 0) {
                            temp[i][j] = 0;
                        }
                    }
                }
            }

            //3. 분리된 빙산 개수 구하기
            boolean[][] visited = new boolean[n][m];
            int cnt = 0;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] > 0 && !visited[i][j]) {
                        dfs(temp, visited, i, j);
                        cnt++;
                        flag = true;
                    }
                }
            }
            if (!flag) {
                if (cnt == 0) {
                    System.out.println(0);
                    break;
                }
                System.out.println(year - 1);
                break;
            }
            if (cnt >= 2) {
                System.out.println(year);
                break;
            }
            for (int i = 0; i < n; i++) {
                System.arraycopy(temp[i], 0, map[i], 0, m);
            }
        }
    }

    public static void dfs(int[][] map, boolean[][] visited, int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) {
                continue;
            }
            if (map[ny][nx] > 0 && !visited[ny][nx]) {
                dfs(map, visited, ny, nx);
            }
        }
    }
}

