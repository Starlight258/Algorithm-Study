import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[][] belt;
    static boolean[][] robot;

    public static void main(String[] args) throws IOException {
        //1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[2][n];
        robot = new boolean[2][n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            belt[0][i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n - 1; i >= 0; i--) {
            belt[1][i] = Integer.parseInt(st.nextToken());
        }
        //2. 작업 수행
        int step = 1;
        while (true) {
            rotateBelt();
            removeRobot();

            moveRobot();
            addRobot();
            if (isEnd()) {
                break;
            }
            step++;
        }
        System.out.println(step);
    }

    private static void rotateBelt() {
        int tempB = belt[0][n - 1];
        boolean tempR = robot[0][n - 1];
        for (int i = n - 1; i >= 1; i--) {
            belt[0][i] = belt[0][i - 1];
            robot[0][i] = robot[0][i - 1];
        }
        belt[0][0] = belt[1][0];
        robot[0][0] = robot[1][0];

        // 두번째 줄
        for (int i = 0; i <= n - 2; i++) {
            belt[1][i] = belt[1][i + 1];
            robot[1][i] = robot[1][i + 1];
        }
        belt[1][n - 1] = tempB;
        robot[1][n - 1] = tempR;
    }

    private static void moveRobot() {
        for (int i = n - 2; i >= 0; i--) {
            if (robot[0][i]) {
                if (belt[0][i + 1] > 0 && !robot[0][i + 1]) {
                    belt[0][i + 1]--;
                    robot[0][i] = false;
                    robot[0][i + 1] = true;
                }
            }
        }
    }

    private static void removeRobot() {
        robot[0][n - 1] = false;
        for (int i = 0; i < n; i++) {
            robot[1][i] = false;
        }
    }

    private static void addRobot() {
        if (belt[0][0] > 0) {
            belt[0][0]--;
            robot[0][0] = true;
        }
    }

    private static boolean isEnd() {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if (belt[i][j] == 0) {
                    count++;
                }
            }
        }
        return count >= k;
    }
}
