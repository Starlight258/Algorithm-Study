import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final String[] COMMAND = {"D", "S", "L", "R"};
    
    static Queue<Integer> q;
    static String[] command;
    static boolean[] visited;

    static String bfs(int a, int b) {
        q = new LinkedList<>();
        command = new String[10001];
        visited = new boolean[10001];
        Arrays.fill(command, "");

        q.add(a);
        command[a] = "";
        visited[a] = true;

        while (!q.isEmpty()) {
            int curNum = q.poll();
            int nextNum = curNum;

            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0: // D
                        nextNum = curNum * 2 % 10000;
                        break;
                    case 1: // S
                        nextNum = curNum == 0 ? 9999 : curNum - 1;
                        break;
                    case 2: // L
                        nextNum = (curNum % 1000) * 10 + curNum / 1000;
                        break;
                    case 3: // R
                        nextNum = (curNum % 10) * 1000 + curNum / 10;
                        break;
                }
                if (curNum == b) {
                    return command[b];
                }
                if (!visited[nextNum]) {
                    q.add(nextNum);
                    command[nextNum] = command[curNum] + COMMAND[i];
                    visited[nextNum] = true;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(bfs(a, b));
        }
    }
}
