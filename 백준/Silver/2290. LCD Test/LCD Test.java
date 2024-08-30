import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int s;
    static String n;
    static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        n = st.nextToken();
        int height = s * 2 + 3;
        int width = (s + 2) * n.length(); // 총 너비
        result = new char[height][width + 1];

        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            LCD(num, i); // 숫자, 위치
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 1; j <= width; j++) {
                if (result[i][j] == '-' || result[i][j] == '|') {
                    sb.append(result[i][j]);
                } else {
                    sb.append(" ");
                }
                if (j % (s + 2) == 0) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void LCD(int num, int index) {
        if (num == 1) {
            vertical(index, 3);
            vertical(index, 4);
        } else if (num == 2) {
            hypen(index, 0);
            vertical(index, 3);
            hypen(index, 1);
            vertical(index, 2);
            hypen(index, 2);
        } else if (num == 3) {
            hypen(index, 0);
            vertical(index, 3);
            hypen(index, 1);
            vertical(index, 4);
            hypen(index, 2);
        } else if (num == 4) {
            vertical(index, 1);
            vertical(index, 3);
            hypen(index, 1);
            vertical(index, 4);
        } else if (num == 5) {
            hypen(index, 0);
            vertical(index, 1);
            hypen(index, 1);
            vertical(index, 4);
            hypen(index, 2);
        } else if (num == 6) {
            hypen(index, 0);
            vertical(index, 1);
            hypen(index, 1);
            vertical(index, 2);
            vertical(index, 4);
            hypen(index, 2);
        } else if (num == 7) {
            hypen(index, 0);
            vertical(index, 3);
            vertical(index, 4);
        } else if (num == 8) {
            hypen(index, 0);
            vertical(index, 1);
            vertical(index, 3);
            hypen(index, 1);
            vertical(index, 2);
            vertical(index, 4);
            hypen(index, 2);
        } else if (num == 9) {
            hypen(index, 0);
            vertical(index, 1);
            vertical(index, 3);
            hypen(index, 1);
            vertical(index, 4);
            hypen(index, 2);
        } else if (num == 0) {
            hypen(index, 0);
            vertical(index, 1);
            vertical(index, 3);
            vertical(index, 2);
            vertical(index, 4);
            hypen(index, 2);
        }
    }

    private static void hypen(int index, int command) {
        int row = command * s + command;
        int col = index * (s + 2) + 2; // 숫자마다 한칸 띄기
        for (int i = 0; i < s; i++) {
            result[row][col + i] = '-';
        }
    }

    private static void vertical(int index, int command) {
        if (command == 1 || command == 2) {
            int row = (command - 1) * s + command;
            int col = index * (s + 2) + 1;
            for (int i = 0; i < s; i++) {
                result[row + i][col] = '|';
            }
        } else if (command == 3 || command == 4) {
            int row = (command - 3) * s + (command - 2);
            int col = index * (s + 2) + s + 2;
            for (int i = 0; i < s; i++) {
                result[row + i][col] = '|';
            }
        }
    }

}
