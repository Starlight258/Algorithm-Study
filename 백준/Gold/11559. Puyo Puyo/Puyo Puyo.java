import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final char[][] map = new char[12][6];
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static boolean[][] visited = new boolean[12][6];
    static boolean[][] deleted = new boolean[12][6];

    private static int dfs(int y, int x) {
        int cnt = 1;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= 12 || nx >= 6) {
                continue;
            }
            if (visited[ny][nx] || map[ny][nx] != map[y][x]) {
                continue;
            }
            cnt += dfs(ny, nx);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int stage = 0;
        while (true) {
            visited = new boolean[12][6];
            deleted = new boolean[12][6];
            boolean isPuyo = false;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        if (dfs(i, j) >= 4) {
                            isPuyo = true;
                            deletePuyo(i, j, map[i][j]);
                        }
                    }
                }
            }

            if (isPuyo) {
                stage++;
            } else {
                break;
            }

            // 삭제하기
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (deleted[i][j]) {
                        map[i][j] = '.';
                    }
                }
            }

            // 이동하기
            for (int i = 0; i < 6; i++) {
                int index = 11;
                // 아래에서부터 찾아서 내리기
                for (int j = 11; j >= 0; j--) {
                    if (map[j][i] != '.') {
                        char temp = map[j][i];
                        map[j][i] = '.';
                        map[index][i] = temp;
                        index--;
                    }
                }
            }
        }
        System.out.println(stage);
    }

    private static void deletePuyo(int y, int x, int color) {
        deleted[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= 12 || nx >= 6) {
                continue;
            }
            if (deleted[ny][nx] || map[ny][nx] != color) {
                continue;
            }
            deletePuyo(ny, nx, color);
        }
    }
}
