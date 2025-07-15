import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int f;
    private static int s;
    private static int g;
    private static int u;
    private static int d;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new boolean[1000001];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s, 0});
        visited[s] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int floor = current[0];
            int count = current[1];

            if (floor == g) {
                System.out.println(count);
                return;
            }

            int up = floor + u;
            int down = floor - d;

            if (up <= f && !visited[up]) {
                queue.offer(new int[]{up, count + 1});
                visited[up] = true;
            }

            if (down >= 1 && !visited[down]) {
                queue.offer(new int[]{down, count + 1});
                visited[down] = true;
            }
        }

        System.out.println("use the stairs");
    }
}
