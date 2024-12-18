import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int d;
    private static int[][] map;
    private static int[] archer;
    private static List<int[]> monsters;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        archer = new int[3];
        monsters = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    monsters.add(new int[]{i, j});
                }
            }
        }
        simulations(0, 0);
        System.out.println(answer);
    }

    private static void simulations(int start, int depth) {
        // 모든 경우의 수
        if (depth == 3) {
            List<int[]> data = copy(monsters);
            attackMonster(data);
            return;
        }
        for (int i = start; i < m; i++) {
            archer[depth] = i;
            simulations(i + 1, depth + 1);
        }
    }

    private static void attackMonster(final List<int[]> monsters) {
        int count = 0;
        while (true) {
            if (monsters.isEmpty()) {
                break;
            }
            List<int[]> targets = new ArrayList<>();
            for (int i = 0; i < 3; i++) { // 각 궁수별로
                PriorityQueue<Monster> pq = new PriorityQueue<>();
                for (int[] monster : monsters) { // 가능한 몬스터 추가
                    int distance = Math.abs(monster[0] - n) + Math.abs(monster[1] - archer[i]);
                    if (distance <= d) {
                        pq.offer(new Monster(monster[0], monster[1], distance));
                    }
                }
                if (!pq.isEmpty()) {
                    Monster monster = pq.poll(); // 가장 가까운 몬스터
                    // 다른 사람이 이미 잡으려고하는지 확인
                    boolean flag = false;
                    for (int[] target : targets) {
                        if (target[0] == monster.y && target[1] == monster.x) {
                            flag = true;
                        }
                    }
                    if (!flag) {
                        targets.add(new int[]{monster.y, monster.x, d});
                    }
                }
            }
            // 궁수별 잡아야하는 몬스터 제거
            for (int[] target : targets) {
                for (int[] monster : monsters) {
                    if (target[0] == monster[0] && target[1] == monster[1]) {
                        monsters.remove(monster);
                        count++;
                        break;
                    }
                }
            }
            // 남아있는 몬스터 제거
            for (int i = monsters.size() - 1; i >= 0; i--) {
                monsters.get(i)[0]++;
                if (monsters.get(i)[0] == n) {
                    monsters.remove(monsters.get(i));
                }
            }
        }
        answer = Math.max(answer, count);
    }

    private static List<int[]> copy(final List<int[]> monsters) {
        List<int[]> tmp = new ArrayList<>();
        for (int[] monster : monsters) {
            tmp.add(new int[]{monster[0], monster[1]});
        }
        return tmp;
    }

    public static class Monster implements Comparable<Monster> {
        int y;
        int x;
        int d;

        public Monster(final int y, final int x, final int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

        @Override
        public int compareTo(final Monster o) {
            if (this.d != o.d) {
                return Integer.compare(this.d, o.d);
            }
            return Integer.compare(this.x, o.x);
        }
    }
}
