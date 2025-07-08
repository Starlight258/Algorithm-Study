import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[r][s];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < s; j++) {
                char c = line.charAt(j);
                if (c == '.') {
                    arr[i][j] = false;
                } else {
                    arr[i][j] = true;
                }
            }
        }

        int answer = 0;
        int max = 0;
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < s; x++) {
                if (arr[y][x]) { // 사람이 있으면
                    for (int k = 0; k < 8; k++) {
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if (ny < 0 || nx < 0 || ny >= r || nx >= s) {
                            continue;
                        }
                        if (arr[ny][nx] && (ny > y || (ny == y && nx > x))) {
                            answer++;
                        }
                    }
                } else {
                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if (ny < 0 || nx < 0 || ny >= r || nx >= s) {
                            continue;
                        }
                        if (arr[ny][nx]) {
                            count++;
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(answer + max);
    }

}
