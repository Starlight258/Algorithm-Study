import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int m;
    private static int n;
    private static char[][] map;
    private static int[] dy = {-1, 0, 1, 0, 0};
    private static int[] dx = {0, 1, 0, -1, 0};
    private static int sy, sx;
    private static int ey, ex;
    private static int cnt;
    private static boolean visit[][];

    static class Signal {
        int dir;
        int a;
        int b;

        public Signal(final int dir, final int a, final int b) {
            this.dir = dir;
            this.a = a;
            this.b = b;
        }
    }

    static class Pair {
        int y;
        int x;

        public Pair(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Signal sig[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) {
                break;
            }
            cnt = 0;
            map = new char[m][n];
            visit = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                map[i] = br.readLine().toCharArray();
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] >= '0' && map[i][j] <= '9') {
                        cnt++;
                    }
                    if (map[i][j] == 'A') {
                        sy = i;
                        sx = j;
                    }
                    if (map[i][j] == 'B') {
                        ey = i;
                        ex = j;
                    }
                }
            }
            sig = new Signal[cnt];

            for (int i = 0; i < cnt; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int d = st.nextToken().equals("-") ? 0 : 1; // 동서, 남북
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sig[n] = new Signal(d, a, b);
            }
            br.readLine();

            int answer = BFS();
            if (answer == -1) {
                sb.append("impossible\n");
            } else {
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int BFS() {
        int time = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(sy, sx));
        visit[sy][sx] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Pair cur = queue.poll();
                if (cur.y == ey && cur.x == ex) {
                    return time;
                }

                for (int d = 0; d < 4; d++) {
                    int ny = cur.y + dy[d];
                    int nx = cur.x + dx[d];
                    if (ny < 0 || nx < 0 || ny >= m || nx >= n) {
                        continue;
                    }
                    if (visit[ny][nx] || map[ny][nx] == '.') {
                        continue;
                    }
                    if (map[ny][nx] == '#' || map[ny][nx] == 'A' || map[ny][nx] == 'B') {
                        visit[ny][nx] = true;
                        queue.offer(new Pair(ny, nx));
                    }
                    if (map[ny][nx] >= '0' && map[ny][nx] <= '9') {
                        int number = map[ny][nx] - '0';
                        if (checkSignal(number, d, time)) {
                            visit[ny][nx] = true;
                            queue.offer(new Pair(ny, nx));
                            continue;
                        }
                        queue.offer(new Pair(cur.y, cur.x));
                    }
                }
            }
            time++;
        }
        return -1;
    }

    private static boolean checkSignal(final int number, final int d, int time) {
        int dir = sig[number].dir;
        int a = sig[number].a;
        int b = sig[number].b;
        int answer = 0;
        time = time % (a + b); // 5 -> a=2, b=3
        // 0,1 // 2,3,4
        // 0,1,2 // 3,4

        if (dir == 0) {
            if (time - a >= 0) {
                answer = (dir + 1) % 2;
            } else {
                answer = dir;
            }
        } else {
            if (time - b >= 0) {
                answer = (dir + 1) % 2;
            } else {
                answer = dir;
            }
        }

        if (answer == 0 && (d == 1 || d == 3)) {
            return true;
        }
        if (answer == 1 && (d == 0 || d == 2)) {
            return true;
        }
        return false;
    }

}
