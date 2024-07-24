import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    private static int dfs(int y, int x) {
        int count = 1;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }
            if (graph[ny][nx] == 0 || visited[ny][nx]) {
                continue;
            }
            count += dfs(ny, nx);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        visited = new boolean[n][n];

        //2. dfs 수행
        int answer = 0;
        List<Integer> homes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    answer++;
                    homes.add(dfs(i, j));
                }
            }
        }

        //3. 출력
        System.out.println(answer);

        Collections.sort(homes);
        for (Integer home : homes) {
            System.out.println(home);
        }
    }
}
