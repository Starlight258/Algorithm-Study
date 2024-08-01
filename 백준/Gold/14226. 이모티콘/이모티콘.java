import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        // bfs
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[s + 1][s + 1];
        q.offer(new int[]{1, 0, 0}); // cur, copy, count
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == s) {
                System.out.println(cur[2]);
                break;
            }

            // 복사
            if (cur[2] + 1 < visited.length && !visited[cur[0]][cur[0]]) {
                visited[cur[0]][cur[0]] = true;
                q.offer(new int[]{cur[0], cur[0], cur[2] + 1});
            }
            // 붙여넣기
            if (cur[0] + cur[1] < visited.length && cur[2] + 1 <= visited.length
                    && !visited[cur[0] + cur[1]][cur[1]]) {
                visited[cur[0] + cur[1]][cur[1]] = true;
                q.offer(new int[]{cur[0] + cur[1], cur[1], cur[2] + 1});
            }
            // 하나 삭제하기
            if (cur[0] - 1 >= 0 && cur[2] + 1 < visited.length && !visited[cur[0] - 1][cur[1]]) {
                visited[cur[0] - 1][cur[1]] = true;
                q.offer(new int[]{cur[0] - 1, cur[1], cur[2] + 1});
            }
        }
    }
}
