import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][n + 1];
        List<Integer>[][] list = new List[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                list[i][j] = new ArrayList<>();
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] horse = new int[k + 1][3];
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            horse[i][0] = Integer.parseInt(st.nextToken()); // y
            horse[i][1] = Integer.parseInt(st.nextToken()); // x
            horse[i][2] = Integer.parseInt(st.nextToken()); // dir

            list[horse[i][0]][horse[i][1]].add(i); // 지도에 말 저장
        }

        // 이동
        int[] dy = {0, 0, 0, -1, 1}; // 0, 1(오른쪽),2(왼쪽),3(위쪽),4(아래쪽)
        int[] dx = {0, 1, -1, 0, 0};

        int count = 0;
        while (count++ < 1000) {

            // 말 움직이기
            for (int i = 1; i <= k; i++) {
                int r = horse[i][0];
                int c = horse[i][1];
                int dir = horse[i][2];

                int nr = r + dy[dir];
                int nc = c + dx[dir];

                if (nr <= n && nr >= 1 && nc >= 1 && nc <= n) {

                    if (map[nr][nc] == 0) { // 흰색
                        // 위에 말까지 함께 옮기기
                        int index = list[r][c].indexOf(i);
                        list[nr][nc].addAll(list[r][c].subList(index, list[r][c].size()));
                        list[r][c] = list[r][c].subList(0, index);

                        // 말 위치 업데이트
                        horse[i][0] = nr;
                        horse[i][1] = nc;
                        for (Integer h : list[nr][nc]) {
                            horse[h][0] = nr;
                            horse[h][1] = nc;
                        }
                    } else if (map[nr][nc] == 1) { // 빨간색
                        // 말 reverse해서 옮기기
                        int index = list[r][c].indexOf(i);
                        List<Integer> subList = list[r][c].subList(index, list[r][c].size());
                        Collections.reverse(subList);

                        list[nr][nc].addAll(subList);
                        list[r][c] = list[r][c].subList(0, index);
                        for (Integer h : list[nr][nc]) {
                            horse[h][0] = nr;
                            horse[h][1] = nc;
                        }
                    } else if (map[nr][nc] == 2) {
                        int new_dir = dir % 2 == 0 ? dir - 1 : dir + 1;
                        horse[i][2] = new_dir;

                        if (r + dy[new_dir] < 1 || r + dy[new_dir] >= n + 1 || c + dx[new_dir] < 1
                                || c + dx[new_dir] >= n + 1) {
                            continue;
                        }

                        if (map[r + dy[new_dir]][c + dx[new_dir]] != 2) {
                            i--;
                        }
                    }

                    // 말이 4개 이상 쌓이는 경우 종료
                    if (list[nr][nc].size() > 3) {
                        System.out.println(count);
                        return;
                    }
                } else {
                    int newDir = dir % 2 == 0 ? dir - 1 : dir + 1;
                    horse[i][2] = newDir;

                    if (map[r + dy[newDir]][c + dx[newDir]] != 2) {
                        i--;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
