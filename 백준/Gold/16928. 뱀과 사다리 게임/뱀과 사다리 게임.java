import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] map;
    static int[] visited;

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) {
                    continue;
                }

                while (map[next] != 0) {
                    next = map[next];
                }

                if (visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    q.add(next);
                }

                if (next == 100) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start] = end;
        }
        visited = new int[101];
        // 2. bfs
        bfs();
        // 3. 정답 출력
        System.out.println(visited[100] - 1);
    }
}
