import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        
        // book_time을 분 단위로 변환하여 times 배열에 저장
        for (int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            times[i][0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            times[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        }
        
        // 입실 시간을 기준으로 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] time : times) {
            // 퇴실 시간이 가장 빠른 객실 확인
            if (!pq.isEmpty() && pq.peek() <= time[0]) {
                pq.poll();
            }
            
            // 현재 객실의 퇴실 시간 + 10분을 pq에 추가
            pq.offer(time[1] + 10);
        }
        
        return pq.size();
    }
}