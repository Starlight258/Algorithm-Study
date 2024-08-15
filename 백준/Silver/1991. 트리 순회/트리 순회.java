import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        nodes = new int[27][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int aNum = st.nextToken().charAt(0) - 'A';
            char b = st.nextToken().charAt(0);
            int bNum = b == '.' ? -1 : b - 'A';
            char c = st.nextToken().charAt(0);
            int cNum = c == '.' ? -1 : c - 'A';
            nodes[aNum] = new int[]{bNum, cNum};
        }

        // 전위 순회
        StringBuilder sb = new StringBuilder();
        preOrder(0, sb);
        System.out.println(sb);

        // 중위순회
        sb = new StringBuilder();
        inOrder(0, sb);
        System.out.println(sb);

        // 후위순회
        sb = new StringBuilder();
        postOrder(0, sb);
        System.out.println(sb);

    }

    private static void preOrder(int cur, StringBuilder sb) {
        sb.append((char) ('A' + cur));

        // 왼쪽
        if (nodes[cur][0] != -1) {
            preOrder(nodes[cur][0], sb);
        }

        // 오른쪽
        if (nodes[cur][1] != -1) {
            preOrder(nodes[cur][1], sb);
        }
    }

    private static void inOrder(int cur, StringBuilder sb) {
        // 왼쪽
        if (nodes[cur][0] != -1) {
            inOrder(nodes[cur][0], sb);
        }

        sb.append((char) ('A' + cur));

        // 오른쪽
        if (nodes[cur][1] != -1) {
            inOrder(nodes[cur][1], sb);
        }
    }

    private static void postOrder(int cur, StringBuilder sb) {
        // 왼쪽
        if (nodes[cur][0] != -1) {
            postOrder(nodes[cur][0], sb);
        }

        // 오른쪽
        if (nodes[cur][1] != -1) {
            postOrder(nodes[cur][1], sb);
        }

        sb.append((char) ('A' + cur));
    }

}
