import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    private static int[][] map;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int[][] students = new int[n*n + 1][5];

        for (int i = 1; i <= n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            students[number][0] = number;
            for (int j = 1; j <= 4; j++) {
                students[number][j] = Integer.parseInt(st.nextToken());
            }
            processEach(number, students[number]);
        }

        System.out.println(calculateTotalSatisfaction(students));
    }

    private static void processEach(int studentNumber, int[] favoriteStudents) {
        Seat bestSeat = findBestSeat(studentNumber, favoriteStudents);
        map[bestSeat.y][bestSeat.x] = studentNumber;
    }

    private static Seat findBestSeat(int studentNumber, int[] favoriteStudents) {
        Seat bestSeat = new Seat(-1, -1, -1, -1);

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] != 0) continue;

                int favoriteCount = 0;
                int emptyCount = 0;

                for (int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;

                    if (map[ny][nx] == 0) {
                        emptyCount++;
                    } else {
                        for (int j = 1; j <= 4; j++) {
                            if (map[ny][nx] == favoriteStudents[j]) {
                                favoriteCount++;
                                break;
                            }
                        }
                    }
                }

                Seat currentSeat = new Seat(y, x, favoriteCount, emptyCount);
                if (bestSeat.compareTo(currentSeat) > 0) {  
                    bestSeat = currentSeat;
                }
            }
        }

        return bestSeat;
    }

    private static int calculateTotalSatisfaction(int[][] students) {
        int totalSatisfaction = 0;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int studentNumber = map[y][x];
                int favoriteCount = 0;

                for (int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;

                    int[] currentStudent = students[studentNumber];
                    for (int j = 1; j <= 4; j++) {
                        if (map[ny][nx] == currentStudent[j]) {
                            favoriteCount++;
                            break;
                        }
                    }
                }

                totalSatisfaction += (favoriteCount > 0) ? Math.pow(10, favoriteCount - 1) : 0;
            }
        }

        return totalSatisfaction;
    }

    static class Seat implements Comparable<Seat> {
        int y, x, favoriteStudentNumber, emptyStudentNumber;

        public Seat(int y, int x, int favoriteStudentNumber, int emptyStudentNumber) {
            this.y = y;
            this.x = x;
            this.favoriteStudentNumber = favoriteStudentNumber;
            this.emptyStudentNumber = emptyStudentNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            if (this.favoriteStudentNumber != seat.favoriteStudentNumber) {
                return Integer.compare(seat.favoriteStudentNumber, this.favoriteStudentNumber);
            }
            if (this.emptyStudentNumber != seat.emptyStudentNumber) {
                return Integer.compare(seat.emptyStudentNumber, this.emptyStudentNumber);
            }
            if (this.y != seat.y) {
                return Integer.compare(this.y, seat.y);
            }
            return Integer.compare(this.x, seat.x);
        }
    }
}
