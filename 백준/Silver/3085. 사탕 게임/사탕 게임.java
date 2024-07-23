import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        //2. brute force - 완전탐색
        // 행 기준으로 swap
        swapRows();
        // 열 기준으로 swap
        swapCols();

        System.out.println(answer);
    }

    private static void swapRows() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1);
                search();
                swap(i, j + 1, i, j);
            }
        }
    }

    private static void swapCols() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                swap(i, j, i + 1, j);
                search();
                swap(i + 1, j, i, j);
            }
        }
    }

    private static void swap(int y1, int x1, int y2, int x2) {
        int temp = arr[y1][x1];
        arr[y1][x1] = arr[y2][x2];
        arr[y2][x2] = temp;
    }

    private static void search() {
        int count;
        // 행 기준으로 찾기
        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    count++;
                    answer = Math.max(answer, count);
                } else {
                    count = 1;
                }
            }
        }

        // 열 기준으로 찾기
        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    count++;
                    answer = Math.max(answer, count);
                } else {
                    count = 1;
                }
            }
        }

        if (answer == n) {
            System.out.println(answer);
            System.exit(0);
        }
    }
}
