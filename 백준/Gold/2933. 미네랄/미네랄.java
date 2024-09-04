import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Loc {
        int y;
        int x;

        public Loc(int i, int j) {
            this.y = i;
            this.x = j;
        }
    }

    static int R;
    static int C;
    static int N;
    static char[][] map;
    static int[][] clusters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        N = Integer.parseInt(br.readLine());
        inputs = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int height = R - Integer.parseInt(inputs[i]);

            destructMineral(height, i % 2 == 0 ? 1 : 2);

            setCluster();
        }

        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }
    }

    public static void destructMineral(int height, int direction) {

        if (direction == 1) { // 왼쪽
            for (int col = 0; col < C; col++) {
                if (map[height][col] == 'x') {
                    map[height][col] = '.';
                    return;
                }
            }
        } else { // 오른쪽
            for (int col = C - 1; col >= 0; col--) {
                if (map[height][col] == 'x') {
                    map[height][col] = '.';
                    return;
                }
            }
        }
    }

    public static void setCluster() {
        clusters = new int[R][C];

        int cluster_num = 1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x' && clusters[i][j] == 0) {
                    if (findCluster(i, j, cluster_num)) { // 떠있는 클러스터를 발견하면
                        return;
                    }
                    cluster_num++;
                }
            }
        }
    }

    public static boolean findCluster(int i, int j, int cluster_num) {

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int lowest = -1;

        Queue<Loc> q = new LinkedList<>();
        ArrayList<Loc> arr = new ArrayList<>();

        q.add(new Loc(i, j));
        clusters[i][j] = cluster_num;

        while (!q.isEmpty()) {

            Loc now = q.poll();

            lowest = Math.max(lowest, now.y);

            for (int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }

                if (clusters[ny][nx] == 0 && map[ny][nx] == 'x') {
                    clusters[ny][nx] = cluster_num;
                    q.add(new Loc(ny, nx));
                }
            }

            arr.add(now);

        }
        if (lowest != R - 1) {
            moveCluster(arr);
            return true;
        }

        return false;
    }

    public static void moveCluster(ArrayList<Loc> arr) {
        int move = 1;

        for (Loc loc : arr) { // 원래꺼 다 지우고
            map[loc.y][loc.x] = '.';
        }

        boolean flag = false;
        while (true) {

            for (Loc loc : arr) {
                if (loc.y + move == R || map[loc.y + move][loc.x] == 'x') {
                    move--;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            move++;
        }

        for (Loc loc : arr) { // 새로 업데이트
            map[loc.y + move][loc.x] = 'x';
        }

    }
}
