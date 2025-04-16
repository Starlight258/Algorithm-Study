import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int month = Integer.parseInt(split[0]);
        int day = Integer.parseInt(split[1]);
        int totalDays = 0;
        for (int i = 1; i < month; i++) {
            totalDays += days[i - 1];
        }
        totalDays += day;
        int answer = (totalDays - 1) % 7;
        printDayOfWeek(answer);
    }

    private static void printDayOfWeek(final int answer) {
        switch (answer) {
            case 0:
                System.out.println("MON");
                break;
            case 1:
                System.out.println("TUE");
                break;
            case 2:
                System.out.println("WED");
                break;
            case 3:
                System.out.println("THU");
                break;
            case 4:
                System.out.println("FRI");
                break;
            case 5:
                System.out.println("SAT");
                break;
            case 6:
                System.out.println("SUN");
                break;
        }
    }
}
