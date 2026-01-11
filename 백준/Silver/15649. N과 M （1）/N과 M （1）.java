import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
    4 2

    1 2
    1 3
    1 4
    2 1
    2 3
    2 4
    3 1
    3 2
    3 4
    4 1
    4 2
    4 3
     */
    private static final boolean[] visited = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        backtracking(new ArrayList<>(), n, m);
    }

    private static void backtracking(final List<Integer> cur, final int n, final int m) {
        if (cur.size() == m) {
            for (Integer i : cur) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            cur.add(i);
            visited[i] = true;
            backtracking(cur, n, m);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }

}
