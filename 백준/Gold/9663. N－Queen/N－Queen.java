import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int n;
    static int answer;
    static ArrayList<Integer> list = new ArrayList<>();
    static void dfs(int row) {
        if (row == n) {
            answer++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (check(col)) {
                list.add(col);
                dfs(row + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    static boolean check(int col) {
        int row = list.size();
        for (int i = 0; i < list.size(); i++) {
            int c = list.get(i);
            if (c == col) {
                return false;
            }
            if (row - i == Math.abs(col - c)) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        answer = 0;
        list = new ArrayList<>(n);
        dfs(0);
        System.out.println(answer);
    }
}
