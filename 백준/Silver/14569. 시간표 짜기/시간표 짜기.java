import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 강의 수
        List<Set<Integer>> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt(); // 강의 시간 수
            Set<Integer> lectureTimes = new HashSet<>();
            for (int j = 0; j < k; j++) {
                lectureTimes.add(sc.nextInt());
            }
            lectures.add(lectureTimes);
        }

        int m = sc.nextInt(); // 학생 수

        for (int i = 0; i < m; i++) {
            int k = sc.nextInt(); // 학생이 들을 수 있는 시간 수
            Set<Integer> studentTimes = new HashSet<>();
            for (int j = 0; j < k; j++) {
                studentTimes.add(sc.nextInt());
            }

            int count = 0;
            for (Set<Integer> lecture : lectures) {
                if (studentTimes.containsAll(lecture)) {
                    count++;
                }
            }
            System.out.println(count);
        }

        sc.close();
    }
}