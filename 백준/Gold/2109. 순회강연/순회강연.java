import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Lecture implements Comparable<Lecture> {
        int pay;
        int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        public int compareTo(Lecture l) {
            return Integer.compare(l.day, this.day);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];

        for (int i = 0; i < lectures.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(pay, day);
        }

        if (n == 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(lectures);

        // 2. 강연하기
        int answer = 0;
        int pos = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = lectures[0].day; i > 0; i--) {
            while (pos < lectures.length && lectures[pos].day == i) {
                    pq.offer(lectures[pos++].pay);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        // 3. 정답 출력
        System.out.println(answer);
    }
}
