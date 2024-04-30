import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] number = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n-1;
        int[] pair = new int[2];
        int answer = 2000000001;

        while (left<right){
            int sum = number[left] + number[right];
            if (Math.abs(sum) < answer){
                answer = Math.abs(sum);
                pair[0] = number[left];
                pair[1] = number[right];
            }
            if (sum==0) break;
            if (sum < 0){
                left++;
            } else right--;
        }

        System.out.println(pair[0] + " " + pair[1]);
    }
}
