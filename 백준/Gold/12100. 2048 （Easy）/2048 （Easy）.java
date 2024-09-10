import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] board;
    private static int maxBlock = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxBlock = Math.max(maxBlock, board[i][j]);
            }
        }

        dfs(0);
        System.out.println(maxBlock);
    }

    private static void dfs(int depth) {
        if (depth == 5) {
            return;
        }

        int[][] tempBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            tempBoard[i] = board[i].clone();
        }

        for (int dir = 0; dir < 4; dir++) {
            move(dir);
            dfs(depth + 1);
            // 회복
            for (int i = 0; i < n; i++) {
                board[i] = tempBoard[i].clone();
            }
        }
    }

    private static void move(int dir) {
        switch (dir) {
            case 0:
                moveUp();
                break;

            case 1:
                moveRight();
                break;
            case 2:
                moveDown();
                break;
            case 3:
                moveLeft();
                break;
        }
    }

    private static void moveUp() {
        for (int col = 0; col < n; col++) {
            int index = 0;
            int block = 0;
            for (int row = 0; row < n; row++) {
                if (board[row][col] != 0) {
                    if (block == board[row][col]) {
                        board[index - 1][col] = block * 2;
                        maxBlock = Math.max(maxBlock, block * 2);
                        block = 0;
                        board[row][col] = block;
                    } else {
                        block = board[row][col];
                        board[row][col] = 0;
                        board[index][col] = block;
                        index++;
                    }
                }
            }
        }
    }

    private static void moveDown() {
        for (int col = 0; col < n; col++) {
            int index = n - 1;
            int block = 0;
            for (int row = n - 1; row >= 0; row--) {
                if (board[row][col] != 0) {
                    if (block == board[row][col]) {
                        board[index + 1][col] = block * 2;
                        maxBlock = Math.max(maxBlock, block * 2);
                        block = 0;
                        board[row][col] = block;
                    } else {
                        block = board[row][col];
                        board[row][col] = 0;
                        board[index][col] = block;
                        index--;
                    }
                }
            }
        }
    }

    private static void moveLeft() {
        for (int row = 0; row < n; row++) {
            int index = 0;
            int block = 0;
            for (int col = 0; col < n; col++) {
                if (board[row][col] != 0) {
                    if (block == board[row][col]) {
                        board[row][index - 1] = block * 2;
                        maxBlock = Math.max(maxBlock, block * 2);
                        block = 0;
                        board[row][col] = block;
                    } else {
                        block = board[row][col];
                        board[row][col] = 0;
                        board[row][index] = block;
                        index++;
                    }
                }
            }
        }
    }

    private static void moveRight() {
        for (int row = 0; row < n; row++) {
            int index = n - 1;
            int block = 0;
            for (int col = n - 1; col >= 0; col--) {
                if (board[row][col] != 0) {
                    if (block == board[row][col]) {
                        board[row][index + 1] = block * 2;
                        maxBlock = Math.max(maxBlock, block * 2);
                        block = 0;
                        board[row][col] = block;
                    } else {
                        block = board[row][col];
                        board[row][col] = 0;
                        board[row][index] = block;
                        index--;
                    }
                }
            }
        }
    }
}
