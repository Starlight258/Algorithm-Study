import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] cheeses;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cheeses = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheeses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            visited = new boolean[n][m];
            makeOutsideAir(visited);

            List<int[]> meltList = findMeltableCheese();
            if (meltList.isEmpty()) {
                break;
            }
            for (int[] pos : meltList) {
                cheeses[pos[0]][pos[1]] = 0;
            }
            time++;
        }
        System.out.println(time);
    }

    private static List<int[]> findMeltableCheese() {
        List<int[]> list = new ArrayList<>();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (cheeses[y][x] == 1) {
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];
                        if (isIn(ny, nx) && cheeses[ny][nx] == 0 && visited[ny][nx]) {
                            count++;
                        }
                    }
                    if (count >= 2) {
                        list.add(new int[]{y, x});
                    }
                }
            }
        }
        return list;
    }

    private static void makeOutsideAir(final boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (isIn(ny, nx) && !visited[ny][nx] && cheeses[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    private static boolean isIn(final int y, final int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
