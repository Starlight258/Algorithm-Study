import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int a;
    private static int b;
    private static int c;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int cur = 0;
        System.out.println(bfs(cur, 0, 0));
    }

    private static int bfs(final int tired, final int work, final int hour) {
        if (hour == 24) {
            return work;
        }
        if (tired + a > m) {
            return bfs(Math.max(tired - c, 0), work, hour + 1);
        }
        return bfs(tired + a, work + b, hour + 1);
    }
    // +A + A -C < M
    // 해당 시점에서 M보다 작아야함
    // A를 더하면서, M보다 크면 쉬기
    // B + B
}
