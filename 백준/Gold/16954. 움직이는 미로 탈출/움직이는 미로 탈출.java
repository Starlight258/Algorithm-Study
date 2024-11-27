import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final char[][] map = new char[8][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        // bfs
        int y = 7;
        int x = 0;
        System.out.println(bfs(y, x));
    }

    private static int bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x));
        for (int round = 0; round < 8; round++) { // 8번만 피하면 모든 벽 사라짐
            int size = queue.size(); 
            for (int count = 0; count < size; count++) { // 같은 높이
                Node now = queue.poll();
                y = now.y;
                x = now.x;
                if (map[y][x] == '.') {
                    queue.add(new Node(y, x));
                } else {
                    continue;
                }
                if (y == 0 && x == 7) {
                    return 1;
                }
                for (int i = 0; i < 8; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= 8 || nx < 0 || nx >= 8 || map[ny][nx] == '#') {
                        continue;
                    }
                    queue.add(new Node(ny, nx));
                }
            }
            // 벽 내리기
            takeDownWall();
        }
        return !queue.isEmpty() ? 1 : 0;
    }

    private static void takeDownWall() {
        for (int c = 0; c < 8; c++) {
            for (int r = 7; r > 0; r--) {
                map[r][c] = map[r - 1][c];
            }
        }
    }

    public static class Node {
        int y;
        int x;

        public Node(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }
}
