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

    private static int W;
    private static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
            Node start = null;
            List<Node> fires = new ArrayList<>();
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '@') {
                        start = new Node(i, j);
                        map[i][j] = '.';
                    }
                    if (map[i][j] == '*') {
                        fires.add(new Node(i, j));
                    }
                }
            }
            int result = process(map, start, fires);
            if (result == 0) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            System.out.println(result);
        }
    }

    private static int process(final char[][] map, final Node start,
                               final List<Node> inputFires) {
        // bfs
        int[][] visited = new int[H][W];
        Queue<Node> person = new LinkedList<>();
        person.offer(start);
        visited[start.y][start.x] = 1;
        Queue<Node> fires = new LinkedList<>();
        for (Node inputFire : inputFires) {
            fires.offer(inputFire);
        }

        while (!person.isEmpty()) {
            // 불 이동
            int size = fires.size();
            for (int round = 0; round < size; round++) {
                Node fire = fires.poll();
                int y = fire.y;
                int x = fire.x;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= H || nx < 0 || nx >= W || map[ny][nx] != '.') {
                        continue;
                    }
                    map[ny][nx] = '*';
                    fires.offer(new Node(ny, nx));
                }
            }
            // 사람 이동
            size = person.size();
            for (int round = 0; round < size; round++) {
                // 상근 이동
                Node now = person.poll();
                int y = now.y;
                int x = now.x;
                if (isExit(y, x)) {
                    return visited[y][x];
                }
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= H || nx < 0 || nx >= W || map[ny][nx] != '.' || visited[ny][nx] != 0) {
                        continue;
                    }
                    visited[ny][nx] = visited[y][x] + 1;
                    person.offer(new Node(ny, nx));
                }
            }
        }
        return 0;
    }

    private static boolean isExit(final int ny, final int nx) {
        return (ny == 0 || ny == H - 1) || (nx == 0 || nx == W - 1);
    }

    static class Node {
        int y;
        int x;

        public Node(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }
}
