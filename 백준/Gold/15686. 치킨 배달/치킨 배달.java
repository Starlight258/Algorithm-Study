import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static List<Node> chickens = new ArrayList<>();
    static List<Node> homes = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void getChickens(int start, List<Integer> selectedChickens, int cnt) {
        if (cnt == m) {
            answer = Math.min(answer, getTotalDistance(selectedChickens));
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selectedChickens.add(i);
            getChickens(i + 1, selectedChickens, cnt + 1);
            selectedChickens.remove(selectedChickens.size() - 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        //1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickens.add(new Node(i, j));
                } else if (map[i][j] == 1) {
                    homes.add(new Node(i, j));
                }
            }
        }
        
        //2. m개의 치킨집 고르기
        getChickens(0, new ArrayList<>(), 0);

        //3. 정답 출력
        System.out.println(answer);
    }

    private static int getTotalDistance(List<Integer> tmpChickens) {
        int totalDistance = 0;
        for (Node home : homes) {
            int minDistance = Integer.MAX_VALUE;
            for (Integer idx : tmpChickens) {
                Node chicken = chickens.get(idx);
                int distance = Math.abs(chicken.y - home.y) + Math.abs(chicken.x - home.x);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }
        return totalDistance;
    }
}
