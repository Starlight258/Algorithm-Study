import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. 입력받기
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        //2. 구현
        int cnt = 1;
        int remain = 64;
        int shortest = 64;
        while (remain != x) {
            if (remain >= x) {
                cnt++;
                shortest /= 2;
                if (remain - shortest >= x) {
                    cnt--;
                    remain -= shortest;
                }
            }
        }

        //3. 정답 출력
        System.out.println(cnt);
    }
}
