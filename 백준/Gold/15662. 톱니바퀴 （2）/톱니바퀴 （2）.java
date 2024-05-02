import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] gear = new int[t][8];
        for (int i = 0; i < t; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }
        int k = Integer.parseInt(br.readLine());
        int[][] rotate = new int[k][2];
        boolean[] visited;
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rotate[i][0] = Integer.parseInt(st.nextToken()) - 1;
            rotate[i][1] = Integer.parseInt(st.nextToken());
        }
        // 2. 회전시키기
        for (int i = 0; i < k; i++) {
            visited = new boolean[t];
            rotateOneGear(t, gear, rotate[i], visited);
        }

        // 3. 정답 계산
        int answer = 0;
        for (int i = 0; i < t; i++) {
            if (gear[i][0] == 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void rotateOneGear(int t, int[][] gear, int[] rotate, boolean[] visited) {
        int num = rotate[0]; // 0번부터 시작하도록 변경
        int dir = rotate[1];
        if (num < 0 || num >= t) {
            return;
        }
        visited[num] = true;

        // 기어의 왼쪽, 오른쪽 인덱스를 찾기
        int left = gear[num][2];
        int right = gear[num][6];

        // 현재 기어에서 왼쪽 기어에 있는 기어 회전 여부 확인
        if (num - 1 >= 0 && gear[num][6] != gear[num - 1][2] && !visited[num - 1]) {
            rotateOneGear(t, gear, new int[]{num - 1, dir * -1}, visited);
        }

        // 현재 기어에서 오른쪽 기어에 있는 기어 회전 여부 확인
        if (num < t - 1 && gear[num][2] != gear[num + 1][6] && !visited[num + 1]) {
            rotateOneGear(t, gear, new int[]{num + 1, dir * -1}, visited);
        }

        rotate(gear[num], dir);
    }

    static void rotate(int[] gear, int dir) {
        if (dir == 1) { // 시계 방향
            int temp = gear[7];
            for (int i = 7; i > 0; i--) {
                gear[i] = gear[i - 1];
            }
            gear[0] = temp;
        } else { // 반시계 방향
            int temp = gear[0];
            for (int i = 0; i < 7; i++) {
                gear[i] = gear[i + 1];
            }
            gear[7] = temp;
        }
    }
}
