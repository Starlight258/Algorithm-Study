import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int t;
    static int[][] graph;
    static int[][] updateDegree;
    static List<int[]> airpurifier;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        graph = new int[r][c];
        updateDegree = new int[r][c];
        airpurifier = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == -1) {
                    airpurifier.add(new int[]{i, j});
                }
            }
        }

        while (t-- > 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (graph[i][j] > 0) {
                        diffusion(i, j);
                    }
                }
            }
            // update하기
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (graph[i][j] == -1) {
                        continue;
                    }
                    graph[i][j] += updateDegree[i][j];
                }
            }
            // 공기청정기 작동
            doAirPurifier();
            // 초기화
            for (int i = 0; i < r; i++) {
                Arrays.fill(updateDegree[i], 0);
            }
        }
        int answer = 0;
        // 미세먼지 양 구하기
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (graph[i][j] != -1) {
                    answer += graph[i][j];
                }
            }
        }
        System.out.println(answer);
    }

    private static void diffusion(int i, int j) {
        int cnt = 0; // 확산 방향
        boolean aflag = false, bflag = false, cflag = false, dflag = false;
        // <-
        if (i - 1 >= 0 && graph[i - 1][j] != -1) {
            aflag = true;
            cnt++;
        }
        // ->
        if (i + 1 < r && graph[i + 1][j] != -1) {
            bflag = true;
            cnt++;
        }
        // 위
        if (j + 1 < c && graph[i][j + 1] != -1) {
            cflag = true;
            cnt++;
        }
        // 아래
        if (j - 1 >= 0 && graph[i][j - 1] != -1) {
            dflag = true;
            cnt++;
        }
        int plus = graph[i][j] / 5;
        graph[i][j] -= (plus) * cnt;

        // 업데이트 할 배열
        if (aflag) {
            updateDegree[i - 1][j] += plus;
        }
        if (bflag) {
            updateDegree[i + 1][j] += plus;
        }
        if (cflag) {
            updateDegree[i][j + 1] += plus;
        }
        if (dflag) {
            updateDegree[i][j - 1] += plus;
        }
    }

    private static void doAirPurifier() {
        int y1 = airpurifier.get(0)[0];
        int y2 = airpurifier.get(1)[0];

        // 아래
        for (int i = y1 - 1; i >= 1; i--) {
            graph[i][0] = graph[i - 1][0];
        }
        // <-
        for (int i = 0; i < c - 1; i++) {
            graph[0][i] = graph[0][i + 1];
        }
        // 위
        for (int i = 0; i <= y1 - 1; i++) {
            graph[i][c - 1] = graph[i + 1][c - 1];
        }
        // ->
        for (int i = c - 1; i > 1; i--) {
            graph[y1][i] = graph[y1][i - 1];
        }

        // 에어컨 옆 칸
        graph[y1][1] = 0;
        // 위
        for (int i = y2 + 1; i < r - 1; i++) {
            graph[i][0] = graph[i + 1][0];
        }
        // <-
        for (int i = 0; i < c - 1; i++) {
            graph[r - 1][i] = graph[r - 1][i + 1];
        }
        // 아래
        for (int i = r - 1; i > y2; i--) {
            graph[i][c - 1] = graph[i - 1][c - 1];
        }
        // ->
        for (int i = c - 1; i > 1; i--) {
            graph[y2][i] = graph[y2][i - 1];
        }
        graph[y2][1] = 0;
    }
}
