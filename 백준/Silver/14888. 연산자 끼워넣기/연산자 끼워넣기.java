import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] arr;

    public static void dfs(int depth, int total, int[] mark) {
        if (depth == n - 1) {
            min = Math.min(min, total);
            max = Math.max(max, total);
            return;
        }

        if (mark[0] > 0) {
            mark[0]--;
            dfs(depth + 1, total + arr[depth + 1], mark);
            mark[0]++;
        }
        if (mark[1] > 0) {
            mark[1]--;
            dfs(depth + 1, total - arr[depth + 1], mark);
            mark[1]++;
        }
        if (mark[2] > 0) {
            mark[2]--;
            dfs(depth + 1, total * arr[depth + 1], mark);
            mark[2]++;
        }
        if (mark[3] > 0) {
            mark[3]--;
            dfs(depth + 1, total / arr[depth + 1], mark);
            mark[3]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] mark = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            mark[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, arr[0], mark);

        System.out.println(max);
        System.out.println(min);
    }
}
