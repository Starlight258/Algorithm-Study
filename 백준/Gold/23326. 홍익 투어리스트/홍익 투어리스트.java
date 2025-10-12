import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) {
                set.add(i + 1);
            }
        }
        int cur = 1;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    int i = Integer.parseInt(st.nextToken());
                    if (set.contains(i)) {
                        set.remove(i);
                    } else {
                        set.add(i);
                    }
                    break;
                case 2:
                    int x = Integer.parseInt(st.nextToken());
                    cur = ((cur - 1 + x) % n) + 1;
                    break;
                case 3:
                    if (set.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    }
                    Integer ceiling = set.ceiling(cur);
                    if (ceiling == null) {
                        System.out.println(set.first() + n - cur);
                    } else {
                        System.out.println(ceiling - cur);
                    }
                    break;
            }
        }
    }
    // 1 i : i번 구역이 명소가 아니었다면 명소로 지정, 명소였다면 지정 풀림
    // 2 x : 시계방향으로 x만큼 이동
    // 3 : 시계 방향으로 최소 몇 칸 움직여야하는지 출력, 존재하지 않으면 -1
    // 0 0 0 0 1 : (1-1)+ 9 %5 = 4+1;
    // 반복문
}
