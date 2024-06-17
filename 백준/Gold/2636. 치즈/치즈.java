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
    static int[][] arr;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<int[]> meltingCheese;

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        meltingCheese = new ArrayList<>();
        int lastCount = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]==1) lastCount++;
            }
        }
        //2. 치즈 녹이기
        int step = 0;
        while (true) {
            step++;
            bfs();
            melting();

            int count = getCount();
            if (count == 0) {
                break;
            }
            lastCount = count;
        }
        //3. 정답 출력
        System.out.println(step);
        System.out.println(lastCount);
    }

    private static void melting() {
        for (int[] cheese : meltingCheese) {
            arr[cheese[0]][cheese[1]] = 0;
        }
    }

    public static void bfs() {
        int[][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (visited[ny][nx] == 0) {
                    if (arr[ny][nx] == 0) {
                        q.add(new int[]{ny, nx});
                    }
                    if (arr[ny][nx] == 1) {
                        meltingCheese.add(new int[]{ny, nx});
                    }
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }
    }

    private static int getCount() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
