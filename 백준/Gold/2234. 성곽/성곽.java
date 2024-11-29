import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {0, -1, 0, 1};
    private static final int[] dx = {-1, 0, 1, 0};

    private static int n;
    private static int m;
    private static int[][] map;
    private static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        area = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dfs
        int number = 0;
        int maxCount = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 0) {
                    number++;
                    int count = dfs(i, j, number);
                    counts.put(number, count);
                    maxCount = Math.max(count, maxCount);
                }
            }
        }
        System.out.println(number);
        System.out.println(maxCount);
        System.out.println(findingAdjacentRoomAreas(counts));
    }

    private static int findingAdjacentRoomAreas(final Map<Integer, Integer> counts) {
        int maxRoomNumber = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                for (int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if (area[y][x] != area[ny][nx]) {
                        maxRoomNumber = Math.max(maxRoomNumber,
                                counts.get(area[y][x]) + counts.get(area[ny][nx]));
                    }
                }
            }
        }
        return maxRoomNumber;
    }

    private static int dfs(final int y, final int x, final int number) {
        area[y][x] = number;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            if ((map[y][x] & (1 << i)) == 0) { // 벽이 없으면 이동
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || area[ny][nx] != 0) {
                    continue;
                }
                count += dfs(ny, nx, number);
            }
        }
        return count;
    }
}
