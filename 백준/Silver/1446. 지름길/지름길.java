import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 1_000_000_000;
    private static int n;
    private static int d;

    public static class Path {
        int e;
        int weight;

        public Path(final int e, final int weight) {
            this.e = e;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        List<List<Path>> pathes = new ArrayList<>();
        for (int i = 0; i <= d; i++) {
            pathes.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (e > d) {
                continue;
            }
            if (e - s <= weight) {
                continue;
            }
            pathes.get(s).add(new Path(e, weight));
        }

        int[] dist = new int[10_001];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        for (int i = 0; i <= d; i++) {
            dist[i + 1] = Math.min(dist[i] + 1, dist[i + 1]);

            for (Path path : pathes.get(i)) {
                int distance = dist[i] + path.weight;
                if (dist[path.e] > distance) {
                    dist[path.e] = distance;
                }
            }
        }
        System.out.println(dist[d]);
    }
}
