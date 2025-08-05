import java.io.*;

public class Main {
    
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        drawStar(0, 0, N, false);

        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            for (char ch : row) {
                sb.append(ch);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void drawStar(int x, int y, int size, boolean blank) {
        if (blank) {
            fillBlank(x, y, size);
            return;
        }

        if (size == 1) {
            map[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count++;
                boolean nextBlank = (count == 5); // 가운데만 공백
                drawStar(x + i * newSize, y + j * newSize, newSize, nextBlank);
            }
        }
    }

    static void fillBlank(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = ' ';
            }
        }
    }
}

