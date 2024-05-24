import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, w;
    static int[] px = new int[1003];
    static int[] py = new int[1003];
    static int[][] dp = new int[1003][1003];
    static int y, x;

    static int getDistance(int a, int b) {
        return Math.abs(px[a] - px[b]) + Math.abs(py[a] - py[b]);
    }

    static int move(int accOfCar1, int accOfCar2) {
        if (accOfCar1 == w + 1 || accOfCar2 == w + 1) return 0;
        if (dp[accOfCar1][accOfCar2] != 0) return dp[accOfCar1][accOfCar2];

        int next = Math.max(accOfCar1, accOfCar2) + 1; // 다음 사건
        return dp[accOfCar1][accOfCar2] = Math.min(
                move(next, accOfCar2) + getDistance(accOfCar1, next), // car1이 움직이는 경우
                move(accOfCar1, next) + getDistance(accOfCar2, next)); // car2가 움직이는 경우
    }

    static void solve() {
        int car1 = 0, car2 = 1;
        for (int accident = 2; accident < w + 2; accident++) {
            // car1이 움직이는 경우 vs car2가 움직이는 경우
            if (dp[accident][car2] + getDistance(car1, accident) < dp[car1][accident] + getDistance(car2, accident)) {
                System.out.println("1");
                car1 = accident;
            } else {
                System.out.println("2");
                car2 = accident;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());

        px[0] = 1;
        py[0] = 1;
        px[1] = n;
        py[1] = n;

        StringTokenizer st;
        for (int i = 2; i < w + 2; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            py[i] = y;
            px[i] = x;
        }

        System.out.println(move(0, 1));
        solve();
    }
}
