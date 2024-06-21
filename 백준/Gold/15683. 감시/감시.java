import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] graph;
    static List<int[]> cctvs;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        cctvs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= graph[i][j] && graph[i][j] <= 5) {
                    cctvs.add(new int[]{i, j});
                }
            }
        }
        //2. 완전탐색하기
        dfs(0, new ArrayList<>());

        //3. 정답 출력하기
        System.out.println(answer);
    }

    private static void dfs(int depth, List<Integer> directions) {
        if (depth == cctvs.size()) {
            // 감시 영역 구하기
            getAreas(directions);
            return;
        }
        int[] cctv = cctvs.get(depth);
        int d = graph[cctv[0]][cctv[1]];
        for (int i = 0; i < getDirection(d).size(); i++) {
            directions.add(getDirection(d).get(i));
            dfs(depth + 1, directions);
            directions.remove(directions.size() - 1);
        }
    }

    private static void getAreas(List<Integer> directions) {
        int[][] map = new int[graph.length][];
        for (int i = 0; i < graph.length; i++) {
            map[i] = graph[i].clone();
        }
        for (int i = 0; i < cctvs.size(); i++) {
            int[] cctv = cctvs.get(i);
            fillArea(cctv, directions.get(i), map);
        }

        // 개수 세기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    result++;
                }
            }
        }
        answer = Math.min(answer, result);
    }

    private static void fillArea(int[] cctv, int d, int[][] map) {
        int y = cctv[0];
        int x = cctv[1];
        int kind = map[cctv[0]][cctv[1]]; // cctv 종류
        switch (kind) {
            case 1:
                if (d == 0) { // ->
                    goRight(map, y, x);
                } else if (d == 1) { //
                    goDown(map, y, x);
                } else if (d == 2) { // <-
                    goLeft(map, y, x);
                } else if (d == 3) {
                    goUp(map, y, x);
                }
                break;
            case 2:
                if (d == 0) {
                    goRight(map, y, x);
                    goLeft(map, y, x);
                } else if (d == 1) {
                    goUp(map, y, x);
                    goDown(map, y, x);
                }
                break;
            case 3:
                if (d == 0) {
                    goUp(map, y, x);
                    goRight(map, y, x);
                } else if (d == 1) {
                    goRight(map, y, x);
                    goDown(map, y, x);
                } else if (d == 2) {
                    goDown(map, y, x);
                    goLeft(map, y, x);
                } else if (d == 3) {
                    goLeft(map, y, x);
                    goUp(map, y, x);
                }
                break;
            case 4:
                if (d == 0) {
                    goLeft(map, y, x);
                    goUp(map, y, x);
                    goRight(map, y, x);
                } else if (d == 1) {
                    goUp(map, y, x);
                    goRight(map, y, x);
                    goDown(map, y, x);
                } else if (d == 2) {
                    goRight(map, y, x);
                    goDown(map, y, x);
                    goLeft(map, y, x);
                } else if (d == 3) {
                    goDown(map, y, x);
                    goLeft(map, y, x);
                    goUp(map, y, x);
                }
                break;
            case 5:
                if (d == 0) {
                    goUp(map, y, x);
                    goRight(map, y, x);
                    goDown(map, y, x);
                    goLeft(map, y, x);
                }
                break;
        }

    }

    private static void goRight(int[][] map, int y, int x) {
        for (int i = x + 1; i < m; i++) {
            if (map[y][i] == 6) {
                break;
            }
            if (1 <= map[y][i] && map[y][i] <= 5) {
                continue;
            }
            map[y][i] = 7;
        }
    }

    private static void goDown(int[][] map, int y, int x) {
        for (int i = y + 1; i < n; i++) {
            if (map[i][x] == 6) {
                break;
            }
            if (1 <= map[i][x] && map[i][x] <= 5) {
                continue;
            }
            map[i][x] = 7;
        }
    }

    private static void goLeft(int[][] map, int y, int x) {
        for (int i = x - 1; i >= 0; i--) {
            if (map[y][i] == 6) {
                break;
            }
            if (1 <= map[y][i] && map[y][i] <= 5) {
                continue;
            }
            map[y][i] = 7;
        }
    }

    private static void goUp(int[][] map, int y, int x) {
        for (int i = y - 1; i >= 0; i--) {
            if (map[i][x] == 6) {
                break;
            }
            if (1 <= map[i][x] && map[i][x] <= 5) {
                continue;
            }
            map[i][x] = 7;
        }
    }

    private static List<Integer> getDirection(int d) {
        List<Integer> direction = new ArrayList<>();
        switch (d) {
            case 1:
                direction.addAll(List.of(0, 1, 2, 3));
                break;
            case 2:
                direction.addAll(List.of(0, 1));
                break;
            case 3:
                direction.addAll(List.of(0, 1, 2, 3));
                break;
            case 4:
                direction.addAll(List.of(0, 1, 2, 3));
                break;
            case 5:
                direction.add(0);
                break;
        }
        return direction;
    }
}
