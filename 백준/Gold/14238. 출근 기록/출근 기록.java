import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int aCount;
    static int bCount;
    static int cCount;
    static boolean visited[][][][][];

    private static void dfs(int aCount, int bCount, int cCount, int prev, int prevprev, String result) {
        if (aCount == 0 && bCount == 0 & cCount == 0) {
            System.out.println(result);
            System.exit(0);
        }

        if (visited[aCount][bCount][cCount][prev][prevprev]) {
            return;
        }
        visited[aCount][bCount][cCount][prev][prevprev] = true;

        if (aCount > 0) {
            dfs(aCount - 1, bCount, cCount, 0, prev, result + 'A');
        }
        if (bCount > 0 && prev != 1) {
            dfs(aCount, bCount - 1, cCount, 1, prev, result + 'B');
        }
        if (cCount > 0 && prev != 2 && prevprev != 2) {
            dfs(aCount, bCount, cCount - 1, 2, prev, result + 'C');
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int aCount = 0, bCount = 0, cCount = 0;

        for (char c : line.toCharArray()) {
            if (c == 'A') {
                aCount++;
            } else if (c == 'B') {
                bCount++;
            } else {
                cCount++;
            }
        }
        visited = new boolean[aCount + 1][bCount + 1][cCount + 1][3][3];

        dfs(aCount, bCount, cCount, 0, 0, "");
        System.out.println(-1);
    }
}
