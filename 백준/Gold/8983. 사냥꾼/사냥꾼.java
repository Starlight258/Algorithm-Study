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
        // 2. 동물 순회하면서 적절한 사격대 찾기(O(logN)
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            int[] animal = animals.get(i);
            int x = animal[0];
            int y = animal[1];
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                Integer shootPos = shoot.get(mid);
                int distance = calculateDistance(x, y, shootPos);
                if (distance <= l) {
                    cnt++;
                    break;
                }
                if (shootPos < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        System.out.println(cnt);
    }

    private static int calculateDistance(int x, int y, int shoot) {
        return Math.abs(x - shoot) + y;
    }
}
