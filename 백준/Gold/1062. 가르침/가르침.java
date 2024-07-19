import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static String[] arr;
    static int answer = Integer.MIN_VALUE;
    static boolean[] visited;

    public static void dfs(int start, int depth) {
        if (depth == k - 5) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < arr[i].length(); j++) {
                    if (!visited[arr[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 입력하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (k < 5) {
            System.out.println(0);
            return;
        }
        arr = new String[n];
        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            word = word.substring(4, word.length() - 4);
            arr[i] = word;
        }

        //2. 완전탐색
        dfs(0, 0);

        //3. 정답 출력
        System.out.println(answer);
    }
}
