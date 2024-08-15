import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int[] visited = new int[MAX];
        visited[n] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == k) {
                break;
            }

            if (cur + 1 < MAX && visited[cur + 1] == 0) {
                visited[cur + 1] = visited[cur] + 1;
                q.offer(cur + 1);
            }
            if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                visited[cur - 1] = visited[cur] + 1;
                q.offer(cur - 1);
            }
            if (cur * 2 < MAX && visited[cur * 2] == 0) {
                visited[cur * 2] = visited[cur] + 1;
                q.offer(cur * 2);
            }
        }

        System.out.println(visited[k] - 1);
    }
}
