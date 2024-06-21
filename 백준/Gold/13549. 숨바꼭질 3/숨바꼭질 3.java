import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100000;
    static int n;
    static int k;
    static int[] visited;

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (cur == k) {
                System.out.println(visited[cur] - 1);
                return;
            }
            if (cur * 2 <= MAX && visited[cur * 2] == 0) {
                queue.add(cur * 2);
                visited[cur * 2] = visited[cur];
            }
            if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                queue.add(cur - 1);
                visited[cur - 1] = visited[cur] + 1;
            }
            if (cur + 1 <= MAX && visited[cur + 1] == 0) {
                queue.add(cur + 1);
                visited[cur + 1] = visited[cur] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[MAX + 1];

        //2. bfs
        bfs();

    }
}
