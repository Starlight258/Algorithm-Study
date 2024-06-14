import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("end")) {
                break;
            }
            char[] lineArray = line.toCharArray();
            char[][] arr = new char[3][3];
            int xCount = 0, oCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = lineArray[i * 3 + j];
                    if (arr[i][j] == 'X') {
                        xCount++;
                    } else if (arr[i][j] == 'O') {
                        oCount++;
                    }
                }
            }
            //2. 유효성 여부 확인
            // x, y개수 확인
            if (!(xCount - oCount == 0 || xCount - oCount == 1)) {
                System.out.println("invalid");
                continue;
            }
            // 승리 여부 확인
            boolean xWin = checkWin('X', arr);
            boolean oWin = checkWin('O', arr);
            if (xWin && oWin) {
                System.out.println("invalid");
                continue;
            }
            // 승리
            if (xWin && xCount - oCount != 1
                    || oWin && xCount - oCount != 0
                    || (!xWin && !oWin) && (xCount != 5 && oCount != 4)) {
                System.out.println("invalid");
                continue;
            }
            System.out.println("valid");
        }
    }

    static boolean checkWin(char c, char[][] arr) {
        for (int i = 0; i < 3; i++) {
            // 가로
            if (arr[i][0] == c && arr[i][1] == c && arr[i][2] == c) {
                return true;
            }
            // 세로
            if (arr[0][i] == c && arr[1][i] == c && arr[2][i] == c) {
                return true;
            }
        }
        // 대각선
        if (arr[0][0] == c && arr[1][1] == c && arr[2][2] == c) {
            return true;
        }
        if (arr[0][2] == c && arr[1][1] == c && arr[2][0] == c) {
            return true;
        }
        return false;
    }
}
