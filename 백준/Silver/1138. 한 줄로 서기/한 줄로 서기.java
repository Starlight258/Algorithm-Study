import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        List<Integer> answer = getIntegers(n, list);

        showAnswer(answer);
    }

    private static List<Integer> getIntegers(final int n, final List<Integer> list) {
        List<Integer> answer = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int number = list.get(i);
            int height = i + 1;
            answer.add(number, height);
        }
        return answer;
    }

    private static void showAnswer(final List<Integer> answer) {
        StringBuilder sb = new StringBuilder();
        for (Integer a : answer) {
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    // 1 2 3 4
    // 2 1 1 0
    // 4 2 1 3 -> 가장 키가 큰 순서부터 시작해서
    // 제일 키 큰 사람 먼저 추가
    // 1이면, 키 큰 사람 그 다음 위치에 저장
    // 2이면, 키 큰 사람 두번째 다음 위치에 저장
    // LinkedList

    // 현재 위치 인덱스 -> 앞, 뒤
    // ArrayDeque
    // 5
    // 1 2 3 4 5
    // 0 0 0 0 0
    // 1 2 3 4 5
    // 0 이면, 앞에 추가

    // 6
    // 1 2 3 4 5 6
    // 5 4 3 2 1 0
    // 6 5 4 3 2 1

    // 7
    // 1 2 3 4 5 6 7
    // 6 1 1 1 2 0 0
    // 6 2 3 4 7 5 6

    // 1. 가장 뒤쪽부터 순회
    // 2. insert(위치, 값)
    // -> 위치로 insert List
}
