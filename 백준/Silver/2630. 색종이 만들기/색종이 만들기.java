import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] A;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(white).append('\n').append(blue);
        System.out.println(sb);
    }

    static void cut(int y, int x, int size) {
        if (isMono(y, x, size)) {
            if (A[y][x] == 0) white++;
            else blue++;
            return;
        }

        int h = size / 2;
        cut(y,       x,       h); // 좌상
        cut(y,       x + h,   h); // 우상
        cut(y + h,   x,       h); // 좌하
        cut(y + h,   x + h,   h); // 우하
    }

    static boolean isMono(int y, int x, int size) {
        int color = A[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (A[i][j] != color) return false;
            }
        }
        return true;
    }
}

