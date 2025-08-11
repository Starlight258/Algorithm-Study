import java.io.*;
import java.util.*;

public class Main {
    static class P { int r, c; P(int r, int c){ this.r = r; this.c = c; } }

    static List<P> houses = new ArrayList<>();
    static List<P> chickens = new ArrayList<>();
    static int[][] dist;  // dist[h][c] = 집 h와 치킨 c 사이 거리
    static int H, C, N, M;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) houses.add(new P(i, j));
                else if (v == 2) chickens.add(new P(i, j));
            }
        }

        H = houses.size();
        C = chickens.size();

        // 1) 거리 테이블 미리 계산
        dist = new int[H][C];
        for (int h = 0; h < H; h++) {
            for (int c = 0; c < C; c++) {
                P hh = houses.get(h), cc = chickens.get(c);
                dist[h][c] = Math.abs(hh.r - cc.r) + Math.abs(hh.c - cc.c);
            }
        }

        // 2) 조합으로 M개 선택
        int[] pick = new int[M];     // 선택된 치킨 인덱스 저장
        dfs(0, 0, pick);

        System.out.println(answer);
    }

    // idx: 현재 고려 중인 치킨 인덱스, depth: 현재까지 뽑은 개수
    static void dfs(int idx, int depth, int[] pick) {
        // M개 뽑음 → 도시 치킨 거리 계산
        if (depth == M) {
            answer = Math.min(answer, cityDistance(pick));
            return;
        }
        // 더 이상 선택 불가한 가지 치기 (남은 치킨으로 M 채울 수 없으면 중단)
        if (idx == C) return;
        if (C - idx < M - depth) return;

        // 1) 현재 idx 치킨집 선택
        pick[depth] = idx;
        dfs(idx + 1, depth + 1, pick);

        // 2) 현재 idx 치킨집 건너뛰기
        dfs(idx + 1, depth, pick);
    }

    // 선택된 치킨 인덱스들로 도시 치킨 거리 계산
    static int cityDistance(int[] pick) {
        int sum = 0;

        for (int h = 0; h < H; h++) {
            int best = Integer.MAX_VALUE;
            for (int k = 0; k < M; k++) {
                int cIdx = pick[k];
                int d = dist[h][cIdx];
                if (d < best) best = d;
                // 간단한 프루닝: 0이면 더 볼 필요 없음
                if (best == 0) break;
            }
            sum += best;
            // 전역 최소 넘어서면 더할 필요 없이 조기 종료(소프트 프루닝)
            if (sum >= answer) return sum;
        }
        return sum;
    }
}