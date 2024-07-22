import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int[][] edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = c;
        }
        Arrays.sort(edges, Comparator.comparingInt(e2 -> e2[2]));
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < e; i++) {
            if (find(edges[i][0]) != find(edges[i][1])) {
                union(edges[i][0], edges[i][1]);
                answer += edges[i][2];
            }
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int rootA = parent[a];
        int rootB = parent[b];
        if (rootA > rootB) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
        }
    }


    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = (find(parent[x]));
        }
    }
}
