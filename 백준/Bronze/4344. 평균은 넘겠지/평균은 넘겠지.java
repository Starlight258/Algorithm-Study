import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNumber = Integer.parseInt(br.readLine());
        while (caseNumber-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentNumber = Integer.parseInt(st.nextToken());
            int[] scores = new int[studentNumber];
            int total = getTotal(studentNumber, scores, st);
            int average = total / studentNumber;
            int answer = countOverAverage(studentNumber, scores, average);
            System.out.printf("%.3f%%\n", ((double) answer / studentNumber) * 100);
        }
    }

    private static int getTotal(final int studentNumber, final int[] scores, final StringTokenizer st) {
        int total = 0;
        for (int i = 0; i < studentNumber; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            total += scores[i];
        }
        return total;
    }

    private static int countOverAverage(final int studentNumber, final int[] scores, final int average) {
        int answer = 0;
        for (int i = 0; i < studentNumber; i++) {
            if (scores[i] > average) {
                answer++;
            }
        }
        return answer;
    }
}
