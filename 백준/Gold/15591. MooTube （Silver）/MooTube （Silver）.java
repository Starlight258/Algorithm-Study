import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<ArrayList<Node>> list;

    static class Node {
        int num;
        int cost;

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    static int bfs(int k, int v) {
        boolean[] visited = new boolean[n + 1];
        visited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        int answer = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node node : list.get(cur)) {
                if (!visited[node.num] && node.cost >= k) {
                    queue.add(node.num);
                    visited[node.num] = true;
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        int q = Integer.parseInt(stringTokenizer.nextToken());

        list = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int p = Integer.parseInt(stringTokenizer.nextToken());
            int q2 = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            list.get(p).add(new Node(q2, r));
            list.get(q2).add(new Node(p, r));
        }

        // bfs 수행
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int answer = bfs(k, v);
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
