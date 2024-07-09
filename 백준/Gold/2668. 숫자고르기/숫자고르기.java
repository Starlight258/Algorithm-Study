import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        // 2. 순회하며 찾기
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int start = i;
            int next = start;
            int[] visited = new int[n + 1];
            while (true) {
                if (visited[next] == 1) {
                    if (next == start) {
                        set.add(next);
                        cnt++;
                    }
                    break;
                }
                visited[next] = 1;
                next = numbers[next];
            }
        }
        // 3. 결과 출력
        System.out.println(cnt);
        final ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }
}
