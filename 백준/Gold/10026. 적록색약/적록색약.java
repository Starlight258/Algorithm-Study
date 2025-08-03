import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int GREEN = 6;
    private static final int RED = 17;
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};
    
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - 'A';
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfss(i, j);
                    count++;
                }
            }
        }

        visited = new boolean[n][n];
        int countWithRedAndGreen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfssWithRedAndGreen(i, j);
                    countWithRedAndGreen++;
                }
            }
        }
        System.out.println(count + " " + countWithRedAndGreen);
    }

    private static void dfss(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]) {
                continue;
            }
            if (map[y][x] == map[ny][nx]) {
                dfss(ny, nx);
            }
        }
    }

    private static void dfssWithRedAndGreen(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]) {
                continue;
            }
            if (map[y][x] == map[ny][nx] || (map[y][x] == GREEN && map[ny][nx] == RED) ||
                    (map[y][x] == RED && map[ny][nx] == GREEN)) {
                dfssWithRedAndGreen(ny, nx);
            }
        }
    }

}
