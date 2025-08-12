import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new boolean[N];
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int idx, int count) {
        // N/2명 선택 완료 → 능력치 계산
        if (count == N / 2) {
            calculate();
            return;
        }
        if (idx >= N) return;

        // 선택
        selected[idx] = true;
        dfs(idx + 1, count + 1);

        // 미선택
        selected[idx] = false;
        dfs(idx + 1, count);
    }

    static void calculate() {
        int start = 0, link = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    start += S[i][j] + S[j][i];
                } else if (!selected[i] && !selected[j]) {
                    link += S[i][j] + S[j][i];
                }
            }
        }
        answer = Math.min(answer, Math.abs(start - link));
    }
}