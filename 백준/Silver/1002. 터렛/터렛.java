import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long r1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            long r2 = Long.parseLong(st.nextToken());

            // 같은 중심
            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) sb.append(-1).append('\n'); // 무한대
                else sb.append(0).append('\n');           // 교점 없음
                continue;
            }

            long dx = x1 - x2;
            long dy = y1 - y2;
            long d2 = dx*dx + dy*dy;              // 중심 거리 제곱
            long rp = r1 + r2;                    // 합
            long rm = Math.abs(r1 - r2);          // 차
            long rp2 = rp * rp;
            long rm2 = rm * rm;

            if (d2 == rp2 || d2 == rm2) sb.append(1).append('\n');      // 외접 또는 내접
            else if (rm2 < d2 && d2 < rp2) sb.append(2).append('\n');   // 두 교점
            else sb.append(0).append('\n');                              // 그 외(불교점)
        }

        System.out.print(sb.toString());
    }
}