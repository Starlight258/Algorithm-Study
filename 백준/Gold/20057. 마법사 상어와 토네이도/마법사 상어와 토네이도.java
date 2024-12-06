import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dx = {-1, 0, 1, 0};
    private static final List<List<Wind>> winds = List.of(
            // 왼쪽 방향
            List.of(
                    new Wind(-1, 1, 1), new Wind(1, 1, 1),    
                    new Wind(-2, 0, 2), new Wind(2, 0, 2),     
                    new Wind(0, -2, 5),                       
                    new Wind(-1, 0, 7), new Wind(1, 0, 7),     
                    new Wind(-1, -1, 10), new Wind(1, -1, 10), 
                    new Wind(0, -1, 0)                        
            ),
            // 아래 방향
            List.of(
                    new Wind(-1, -1, 1), new Wind(-1, 1, 1),
                    new Wind(0, -2, 2), new Wind(0, 2, 2),
                    new Wind(2, 0, 5),
                    new Wind(0, -1, 7), new Wind(0, 1, 7),
                    new Wind(1, -1, 10), new Wind(1, 1, 10),
                    new Wind(1, 0, 0)
            ),
            // 오른쪽 방향
            List.of(
                    new Wind(-1, -1, 1), new Wind(1, -1, 1),
                    new Wind(-2, 0, 2), new Wind(2, 0, 2),
                    new Wind(0, 2, 5),
                    new Wind(-1, 0, 7), new Wind(1, 0, 7),
                    new Wind(-1, 1, 10), new Wind(1, 1, 10),
                    new Wind(0, 1, 0)
            ),
            // 위 방향
            List.of(
                    new Wind(1, -1, 1), new Wind(1, 1, 1),
                    new Wind(0, -2, 2), new Wind(0, 2, 2),
                    new Wind(-2, 0, 5),
                    new Wind(0, -1, 7), new Wind(0, 1, 7),
                    new Wind(-1, -1, 10), new Wind(-1, 1, 10),
                    new Wind(-1, 0, 0)
            )
    );

    private static int n;
    private static int[][] map;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        simulation();
        System.out.println(answer);
    }

    private static void simulation() {
        int y = n / 2, x = n / 2;
        int count = 0;
        int move = 1;
        int d = 0;
        while (true) {
            if (count == 2) {
                count = 0;
                if (y > 0) {
                    move++;
                }
            }
            for (int i = 0; i < move; i++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (!isNotInRange(ny, nx) && map[ny][nx] > 0) {
                    moveSand(ny, nx, d);
                }
                y = ny;
                x = nx;
                if (y == 0 && x == 0) {
                    return;
                }
            }
            d = (d + 1) % 4;
            count++;
        }
    }

    private static void moveSand(final int ny, final int nx, final int d) {
        int sand = map[ny][nx];
        map[ny][nx] = 0;
        List<Wind> windsEach = winds.get(d);
        int remaining = sand;
        for (int i = 0; i < windsEach.size() - 1; i++) {
            Wind wind = windsEach.get(i);
            int windY = ny + wind.dy;
            int windX = nx + wind.dx;
            int calculateSand = (int) (sand * (wind.rate / 100.0));
            remaining -= calculateSand;
            if (isNotInRange(windY, windX)) {
                answer += calculateSand;
            } else {
                map[windY][windX] += calculateSand;
            }
        }
        Wind wind = windsEach.get(windsEach.size() - 1);
        int remainingY = ny + wind.dy;
        int remainingX = nx + wind.dx;
        if (isNotInRange(remainingY, remainingX)) {
            answer += remaining;
        } else {
            map[remainingY][remainingX] += remaining;
        }
    }

    private static boolean isNotInRange(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= n || nx >= n;
    }

    static class Wind {
        int dy;
        int dx;
        int rate;

        public Wind(final int dy, final int dx, final int rate) {
            this.dy = dy;
            this.dx = dx;
            this.rate = rate;
        }
    }
}
