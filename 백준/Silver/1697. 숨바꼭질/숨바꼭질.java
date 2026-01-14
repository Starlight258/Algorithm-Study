import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
    수빈이는 걷거나 순간이동을 할 수 있다.
    만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

    수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
     */
    /*
    가장 빠른 시간 : bfs
     */
    /*
    5 17
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = 100_000 * 2;
        int[] visited = new int[max + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        visited[n] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == k) {
                System.out.println(visited[cur] - 1);
                return;
            }
            // +1
            offerElement(cur, max, cur + 1, visited, q);
            // -1
            offerElement(cur, max, cur - 1, visited, q);
            // *2
            offerElement(cur, max, cur * 2, visited, q);
        }

        System.out.println(0);
    }

    private static void offerElement(final int cur, final int max, final int next, final int[] visited,
                                     final Queue<Integer> q) {
        if (next < 0 || next > max || visited[next] != 0) {
            return;
        }
        q.offer(next);
        visited[next] = visited[cur] + 1;
    }
}
