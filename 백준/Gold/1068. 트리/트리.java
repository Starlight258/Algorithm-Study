import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int start, eraseNode;
    static List<List<Integer>> list;
    static int answer;

    static void dfs(int parent, int start){
        if (start == eraseNode) {
            if (list.get(parent).size() == 1) {
                answer++;
            }
            return;
        }
        if (list.get(start).size() == 0) {
            answer++;
            return;
        }
        for (Integer node : list.get(start)) {
            dfs(start, node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        start = 0;
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == -1) {
                start = i;
                continue;
            }
            list.get(input).add(i);
        }
        eraseNode = Integer.parseInt(br.readLine());

        dfs(start, start);

        System.out.println(answer);
    }
}
