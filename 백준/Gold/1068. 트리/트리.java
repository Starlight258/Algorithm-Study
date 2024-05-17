import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int eraseNode;
    static List<List<Integer>> graph;
    static int answer;

    static void dfs(int parent, int current){
        if (current == eraseNode) {
            if (graph.get(parent).size() == 1) {
                answer++;
            }
            return;
        }
        
        if (graph.get(current).size() == 0) {
            answer++;
            return;
        }
        
        for (Integer adjNode : graph.get(current)) {
            dfs(current, adjNode);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int root = 0;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == -1) {
                root = i;
                continue;
            }
            graph.get(input).add(i);
        }
        
        eraseNode = Integer.parseInt(br.readLine());

        dfs(root, root);

        System.out.println(answer);
    }
}
