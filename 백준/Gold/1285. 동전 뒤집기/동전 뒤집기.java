import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {

    static final int INF = 987654321;
    static int n, ret = INF, sum;
    static int[] a = new int[21];

    static void go(int depth){
        if (depth == n + 1) {
            sum = 0;
            // 각 열에 대해 T 개수 구하기
            for (int i = 1; i <= (1 << n - 1); i *= 2) {
                int cnt = 0;
                for (int j = 1; j <= n; j++) {
                    if ((a[j] & i) != 0) {
                        cnt++;
                    }
                }
                sum += Math.min(cnt, n - cnt);
            }
            ret = Math.min(sum, ret);
            return;
        }

        go(depth + 1);
        a[depth] = ~a[depth];
        go(depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String line;
        for (int i = 1; i <= n; i++) {
            line = br.readLine();
            int value = 1;
            for (char c : line.toCharArray()) {
                if (c == 'H') {
                    a[i] |= value;
                }
                value *= 2;
            }
        }

        // 완전 탐색 수행
        go(1);

        // 정답 출력
        System.out.println(ret);
    }
}
