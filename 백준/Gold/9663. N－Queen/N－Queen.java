import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[] map;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n];

        nQueenMethod(0);
        System.out.println(answer);
    }

    private static void nQueenMethod(final int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            map[depth] = i;
            if (canQueen(depth)) {
                nQueenMethod(depth + 1);
            }
        }
    }

    private static boolean canQueen(final int depth) {
        for (int i = 0; i < depth; i++) {
            if (map[i] == map[depth]) {
                return false;
            }
            if (Math.abs(depth - i) == Math.abs(map[depth] - map[i])) {
                return false;
            }
        }
        return true;
    }
}
