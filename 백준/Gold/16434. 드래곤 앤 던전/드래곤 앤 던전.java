import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int hAtk = Integer.parseInt(st.nextToken());
        List<int[]> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            rooms.add(new int[]{t, a, h});
        }
        //2. 게임 수행
        long left = 1, right = Long.MAX_VALUE - 1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long hCurhp = mid; // 현재 체력
            long tempHatk = hAtk; // 공격력
            boolean success = true;
            for (int i = 0; i < n; i++) {
                int t = rooms.get(i)[0];
                int a = rooms.get(i)[1];
                int h = rooms.get(i)[2];
                if (t == 1) { // 몬스터
                    if (h % tempHatk == 0) { // 나누어 떨어지면 마지막 몬스터 공격 안받음
                        hCurhp -= a * ((h / tempHatk) - 1);
                    } else {
                        hCurhp -= a * (h / tempHatk);
                    }
                    if (hCurhp <= 0) {
                        success = false;
                        break;
                    }
                } else { // 포션
                    tempHatk += a;
                    hCurhp += h;
                    if (hCurhp > mid) { // 최대 공격력 넘지 않게함
                        hCurhp = mid;
                    }
                }
            }
            if (success) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
