import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, t;
    static int[][] arr;
    static HashSet<Node> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotate(x, d, k);
            findSame();

            if (set.size() != 0) {
                for (Node node : set) {
                    arr[node.x][node.y] = 0;
                }
            } else {
                adjust();
            }
        }

        System.out.println(sum());
    }

    private static void rotate(int x, int d, int k) {
        for (int i = x; i <= n; i += x) {
            int[] temp = new int[m + 1];
            if (d == 0) { // 시계 방향
                for (int j = 1; j <= m; j++) {
                    temp[(j - 1 + k) % m + 1] = arr[i][j];
                }
            } else { // 반시계 방향
                for (int j = 1; j <= m; j++) {
                    temp[(j - 1 - k + m) % m + 1] = arr[i][j];
                }
            }
            System.arraycopy(temp, 1, arr[i], 1, m);
        }
    }

    private static void findSame() {
        set.clear();
        // 같은 원판 내에서 인접한 수 찾기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 0) continue;
                if (j == 1) {
                    if (arr[i][1] == arr[i][m]) {
                        set.add(new Node(i, 1));
                        set.add(new Node(i, m));
                    }
                }
                if (arr[i][j] == arr[i][j % m + 1]) {
                    set.add(new Node(i, j));
                    set.add(new Node(i, j % m + 1));
                }
            }
        }

        // 다른 원판과 인접한 수 찾기
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 0) continue;
                if (arr[i][j] == arr[i + 1][j]) {
                    set.add(new Node(i, j));
                    set.add(new Node(i + 1, j));
                }
            }
        }
    }

    private static void adjust() {
        double sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] != 0) {
                    sum += arr[i][j];
                    count++;
                }
            }
        }
        if (count == 0) return;
        double avg = sum / count;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 0) continue;
                if (arr[i][j] > avg) {
                    arr[i][j]--;
                } else if (arr[i][j] < avg) {
                    arr[i][j]++;
                }
            }
        }
    }

    private static int sum() {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                total += arr[i][j];
            }
        }
        return total;
    }

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
