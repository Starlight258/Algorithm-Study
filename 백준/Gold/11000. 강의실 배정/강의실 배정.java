import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] lecture = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lecture[i][0] = start;
            lecture[i][1] = end;
        }

        Arrays.sort(lecture, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        //2. 강의실 개수 구하기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lecture[0][1]);
        for (int i = 1; i < n; i++) {
            if (!pq.isEmpty() && pq.peek() <= lecture[i][0]) {
                pq.poll();
            }
            pq.add(lecture[i][1]);
        }
        System.out.println(pq.size());
    }
}
