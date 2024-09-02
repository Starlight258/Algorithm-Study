import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final char[][][] NUMBER = new char[][][]{
            { // 0
                    {'#', '#', '#'},
                    {'#', '.', '#'},
                    {'#', '.', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'},
            },
            { // 1
                    {'#'},
                    {'#'},
                    {'#'},
                    {'#'},
                    {'#'},
            },
            { // 2
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'#', '#', '#'},
                    {'#', '.', '.'},
                    {'#', '#', '#'},
            },
            { // 3
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'#', '#', '#'},
            },
            { // 4
                    {'#', '.', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'.', '.', '#'},
            },
            { // 5
                    {'#', '#', '#'},
                    {'#', '.', '.'},
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'#', '#', '#'},
            },
            { // 6
                    {'#', '#', '#'},
                    {'#', '.', '.'},
                    {'#', '#', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'},
            },
            { // 7
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'.', '.', '#'},
                    {'.', '.', '#'},
                    {'.', '.', '#'},
            },
            { // 8
                    {'#', '#', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'},
            },
            { // 9
                    {'#', '#', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'#', '#', '#'},
            }
    };
    private static final char BLOCK = '#';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int n = 5;
        int m = s / 5;
        char[][] map = new char[n][m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(index++);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (map[0][i] != BLOCK) {
                continue;
            }
            int number = findNumber(i, map, n, m);
            result.append(number);
            if (number != 1) {
                i += 3;
            }
        }
        System.out.println(result);
    }

    private static int findNumber(int index, char[][] map, int n, int m) {
        if (isOne(index, map, n, m)) {
            return 1;
        }
        for (int num = 0; num < 10; num++) {
            if (num == 1) {
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < NUMBER[num][i].length; j++) {
                    if (index + j >= m) { // 열 넘어가는지 검사
                        flag = false;
                        break;
                    }
                    if (map[i][index + j] != NUMBER[num][i][j]) {
                        flag = false;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                return num;
            }
        }
        return -1;
    }

    private static boolean isOne(int index, char[][] map, int n, int m) {
        for (int i = 0; i < n; i++) {
            if (map[i][index] != BLOCK) {
                return false;
            }
        }
        if (index > 0 && map[0][index - 1] == BLOCK) {
            return false;
        }
        if (index < m - 1 && map[0][index + 1] == BLOCK) {
            return false;
        }
        return true;
    }
}
