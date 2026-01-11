import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /*
    오늘은 공주님이 태어난 경사스러운 날이다. 왕은 이 날을 기념하기 위해 늘 꽃이 피어있는 작은 정원을 만들기로 결정했다.
    총 N개의 꽃이 있는 데, 꽃은 모두 같은 해에 피어서 같은 해에 진다. 하나의 꽃은 피는 날과 지는 날이 정해져 있다.
    예를 들어, 5월 8일 피어서 6월 13일 지는 꽃은 5월 8일부터 6월 12일까지는 꽃이 피어 있고, 6월 13일을 포함하여 이후로는 꽃을 볼 수 없다는 의미이다.
    (올해는 4, 6, 9, 11월은 30일까지 있고, 1, 3, 5, 7, 8, 10, 12월은 31일까지 있으며, 2월은 28일까지만 있다.)
    이러한 N개의 꽃들 중에서 다음의 두 조건을 만족하는 꽃들을 선택하고 싶다.
    공주가 가장 좋아하는 계절인 3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 한다.
    정원이 넓지 않으므로 정원에 심는 꽃들의 수를 가능한 적게 한다.
    N개의 꽃들 중에서 위의 두 조건을 만족하는, 즉 3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 꽃들을 선택할 때,
    선택한 꽃들의 최소 개수를 출력하는 프로그램을 작성하시오.
     */

    /*
    시작 날짜 순으로 정렬, 같으면 더 긴 기간
    종료 날짜 2월 28일 이전인 것들 제외
    시작 날짜 11월 30일 이후 제외
    처음 날짜 : 3월 1일부터 간주
    이전 종료 날짜 >= 다음 시작 날짜
    4
    1 1 6 30 -> 선택
    1 1 5 31
    5 15 8 31
    6 10 12 10 -> 선택

    10
    2 15 3 23
    2 28 4 25 -> 선택
    4 12 6 5 -> 선택
    5 2 5 31
    6 3 6 15 -> 선택
    6 15 9 27 -> 선택
    6 15 9 3
    7 14 9 1
    9 14 12 24 -> 선택
    10 5 12 31

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int start = sm * 100 + sd;
            int end = em * 100 + ed;
            times.add(new Time(start, end));
        }

        // 정렬로는 안되는 이유 : 포함하는 긴 날짜를 먼저 가져와야하는데 그걸 모를거다.
        // 정렬 + 반복문으로 포함하는 가장 긴 날짜 선택하기
        Collections.sort(times);
        int answer = 0;
        int cur = 301;
        int end = 1201;
        int index = 0;
        int max = 0;
        while (cur < end) {
            boolean hasUpdated = false;
            for (int i = index; i < n; i++) {
                Time time = times.get(i);
                if (time.start > cur) {
                    break;
                }
                if (max < time.end) {
                    max = time.end;
                    index = i;
                    hasUpdated = true;
                }
            }
            if (hasUpdated) {
                answer++;
                cur = max;
            } else {
                break;
            }
        }
        if (cur < end) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }

    public static class Time implements Comparable<Time> {

        int start;
        int end;

        public Time(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(final Time o) {
            if (o.start == this.start) {
                return o.end - this.end; // 내림차순
            }
            return this.start - o.start; // 오름차순
        }
    }
}
