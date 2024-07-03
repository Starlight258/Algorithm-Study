import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            maxLength = Math.max(maxLength, words[i].length());
        }

        //2. 알파벳 별로 가중치 부여하기
        Map<Character, Integer> weightMap = new HashMap<>();
        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char alpha = word.charAt(i);
                weightMap.put(alpha, weightMap.getOrDefault(alpha, 0) + (int) Math.pow(10, len - i - 1));
            }
        }
        List<Character> characters = new ArrayList<>(weightMap.keySet());
        characters.sort((o1, o2) -> weightMap.get(o2) - weightMap.get(o1));

        //3. 가중치 별로 숫자 부여하기
        HashMap<Character, Integer> numberMap = new HashMap<>();
        int number = 9;

        for (Character character : characters) {
            numberMap.put(character, number--);
        }

        //4. 단어의 가중치 합 구하기
        int sum = 0;
        for (String word : words) {
            int num = 0;
            for (int i = 0; i < word.length(); i++) {
                char alpha = word.charAt(i);
                num = num * 10 + numberMap.get(alpha);
            }
            sum += num;
        }
        System.out.println(sum);
    }
}
