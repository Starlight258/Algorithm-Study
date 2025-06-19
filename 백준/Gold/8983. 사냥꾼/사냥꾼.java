import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        String[] split = bufferedReader.readLine().split(" ");
        List<Integer> shoot = new ArrayList<>();
        for (String s : split) {
            shoot.add(Integer.parseInt(s));
        }
        shoot.sort(Integer::compareTo);
        List<int[]> animals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animals.add(new int[]{x, y});
        }
        animals.sort(((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));
        // 2. 동물 돌면서 사격대와 거리 L 이하인지 확인
        int answer = 0;
        for (int[] animal : animals) {
            int x = animal[0];
            int y = animal[1];
            for (Integer s : shoot) {
                int distance = calculateDistance(x, y, s);
                if (distance <= l) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    private static int calculateDistance(int x, int y, int shoot) {
        return Math.abs(x - shoot) + y;
    }
}
