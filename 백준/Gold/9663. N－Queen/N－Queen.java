import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
     *
     * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
     */
    /**
     * N=3 : 2 * 3 * 3 = 18
     * 3 * 3 - (3+2+2)
     * O O O
     * O O O
     * O O O
     * N=4 : 6 * 4 * 4
     * 4 * 4 - (4+3+3)
     * O O O O (0,0) (0,1) (0,2)
     * O O O O (1,0) (1,1) (1,2)
     * O O O O (2,0) (2,1) (2,2)
     * O O O O (3,0) (3,1) (3,2)
     */
    private static int n;
    private static int answer = 0;
    private static boolean[] colVisited;
    private static boolean[] diagonalVisited;
    private static boolean[] reverseDiagonalVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        colVisited = new boolean[n + 1]; // x
        diagonalVisited = new boolean[n * 2+1]; // x+y
        reverseDiagonalVisited = new boolean[n * 2+1]; // y-x+n-1=5
        backtracking(1);
        System.out.println(answer);
    }

    private static void backtracking(int y) {
        if (y == n + 1) {
            answer++;
            return;
        }
        for (int x = 1; x <= n; x++) {
            if (colVisited[x] || diagonalVisited[y + x] || reverseDiagonalVisited[y - x + n - 1]) {
                continue;
            }
            colVisited[x] = true;
            diagonalVisited[y + x] = true;
            reverseDiagonalVisited[y - x + n - 1] = true;
            backtracking(y + 1);
            colVisited[x] = false;
            diagonalVisited[y + x] = false;
            reverseDiagonalVisited[y - x + n - 1] = false;
        }

    }
}
