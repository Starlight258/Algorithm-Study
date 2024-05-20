import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            total += heights[i];
        }

        total -= 100;

        int[] notIn = new int[2];
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (heights[i] + heights[j] == total){
                    notIn[0] = heights[i];
                    notIn[1] = heights[j];
                }
            }
        }

        Arrays.sort(heights);

        for (int i = 0; i < 9; i++) {
            if (heights[i]==notIn[0] || heights[i] == notIn[1]) continue;
            System.out.println(heights[i]);
        }
    }
}
