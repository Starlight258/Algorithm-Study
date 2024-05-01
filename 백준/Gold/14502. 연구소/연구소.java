import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int[][] mp, int y, int x, boolean[][] visited) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= mp.length || nx >= mp[0].length) {
                continue;
            }
            if (mp[ny][nx] == 0 && !visited[ny][nx]) {
                dfs(mp, ny, nx, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[][] mp = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                mp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Node> emptyList = new ArrayList<>();
        List<Node> virusList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mp[i][j] == 0) {
                    emptyList.add(new Node(i, j));
                }
                if (mp[i][j] == 2) {
                    virusList.add(new Node(i, j));
                }
            }
        }

        // 3개의 벽을 세울 수 있는 모든 경우의 수
        for (int i = 0; i < emptyList.size(); i++) {
            for (int j = i + 1; j < emptyList.size(); j++) {
                for (int k = j + 1; k < emptyList.size(); k++) {
                    mp[emptyList.get(i).y][emptyList.get(i).x] = 1;
                    mp[emptyList.get(j).y][emptyList.get(j).x] = 1;
                    mp[emptyList.get(k).y][emptyList.get(k).x] = 1;

                    for (Node node : virusList) {
                        dfs(mp, node.y, node.x, visited);
                    }
                    answer = Math.max(answer, countSafety(mp, visited));

                    mp[emptyList.get(i).y][emptyList.get(i).x] = 0;
                    mp[emptyList.get(j).y][emptyList.get(j).x] = 0;
                    mp[emptyList.get(k).y][emptyList.get(k).x] = 0;
                    for (int a = 0; a < n; a++) {
                        Arrays.fill(visited[a], false);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static int countSafety(int[][] mp, boolean[][] visited) {
        int result = 0;
        for (int i = 0; i < mp.length; i++) {
            for (int j = 0; j < mp[0].length; j++) {
                if (mp[i][j] == 0 && !visited[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }
}
