import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;
        int y = 0, x = 0;           // 현재 조사 중인 블록의 좌상단
        int size = 1 << n;          // 전체 한 변 길이 = 2^n

        while (n > 0) {
            int half = size >> 1;   // 2^(n-1)
            int area = half * half; // 사분면 한 덩어리 칸 수

            if (r < y + half && c < x + half) {           // 좌상 (0)
                // ans += 0 * area;
                // y, x 그대로
            } else if (r < y + half && c >= x + half) {   // 우상 (1)
                ans += area;
                x += half;
            } else if (r >= y + half && c < x + half) {   // 좌하 (2)
                ans += 2 * area;
                y += half;
            } else {                                      // 우하 (3)
                ans += 3 * area;
                y += half; x += half;
            }
            size = half; // 다음 단계로 절반 축소
            n--;         // 깊이 줄이기
        }
        System.out.println(ans);
    }
}