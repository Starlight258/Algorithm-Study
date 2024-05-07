import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, l;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        l = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            // 행 확인
            if (checkRow(i)) {
                answer++;
            }
            if (checkCol(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean checkRow(int row) {
        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = map[row][i] - map[row][i + 1];
            if (diff < -1 || diff > 1) {
                return false;
            }
            if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || isVisited[i - j] || map[row][i] != map[row][i - j]) {
                        return false;
                    }
                    isVisited[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || isVisited[i + j] || map[row][i]-1 != map[row][i + j]) {
                        return false;
                    }
                    isVisited[i + j] = true;
                }
            }
        }
        return true;
    }

    public static boolean checkCol(int col) {
        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = map[i][col] - map[i + 1][col];
            if (diff > 1 || diff < -1) {
                return false;
            }
            if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || isVisited[i - j] || map[i][col] != map[i - j][col]) {
                        return false;
                    }
                    isVisited[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || isVisited[i + j] || map[i][col]-1 != map[i + j][col]) {
                        return false;
                    }
                    isVisited[i + j] = true;
                }
            }
        }
        return true;
    }
}
