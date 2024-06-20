import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_N = 101;
    static int n;
    static int[][] input;
    static List<Integer> list;
    static boolean[][] map;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = new int[n][4];
        list = new ArrayList<>();
        map = new boolean[MAX_N][MAX_N];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken()); // x
            input[i][1] = Integer.parseInt(st.nextToken()); // y
            input[i][2] = Integer.parseInt(st.nextToken()); // d
            input[i][3] = Integer.parseInt(st.nextToken()); // g
        }

        //2. 드래곤 커브 수행하기
        dragonCurve();

        //3. 사각형 갯수 확인하기
        int answer = 0;
        for (int i = 0; i < MAX_N - 1; i++) {
            for (int j = 0; j < MAX_N - 1; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void dragonCurve() {
        for (int i = 0; i < n; i++) {
            list.add(input[i][2]);

            for (int j = 1; j <= input[i][3]; j++) { // 세대만큼 반복
                for (int k = list.size() - 1; k >= 0; k--) {
                    list.add((list.get(k) + 1) % 4);
                }
            }

            // map에 표시하기
            int x = input[i][0];
            int y = input[i][1];
            map[y][x] = true;

            for (Integer d : list) {
                y += dy[d];
                x += dx[d];
                map[y][x] = true;
            }
            list.clear();
        }
    }
}
