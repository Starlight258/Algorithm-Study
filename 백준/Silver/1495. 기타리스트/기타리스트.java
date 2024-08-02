import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int s;
    static int m;
    static int[] volumes;
    static boolean[][] visited;
    static int answer = -1;

    private static void dfs(int index, int volume) {
        if (index == n) {
            answer = Math.max(answer, volume);
            return;
        }
        if (visited[index][volume]) {
            return;
        }
        visited[index][volume] = true;

        if (volume + volumes[index] <= m) {
            dfs(index + 1, volume + volumes[index]);
        }

        if (volume - volumes[index] >= 0) {
            dfs(index + 1, volume - volumes[index]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        volumes = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        //2. visited
        visited = new boolean[n][1001];
        dfs(0, s);

        //3. 정답 출력
        System.out.println(answer);
    }
}
