import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        // 1. 분으로 저장하여 끝나는 시간 빠른대로 정렬
        List<int[]> list = new ArrayList<>();
        for (String[] book : book_time){
            list.add(new int[]{getMinutes(book[0]), getMinutes(book[1])+10});     
        }
        list.sort(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });
        //2. 방 구하기
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int[] room : list) {
            while (!q.isEmpty() && q.peek() <= room[0]) {
                q.poll();
            }
            q.offer(room[1]);
            answer = Math.max(answer, q.size());
        }

        return answer;
        
    }
    
    private int getMinutes(String time){
        String[] splited = time.split(":");
        int h = Integer.parseInt(splited[0]);
        int m = Integer.parseInt(splited[1]);
        return h * 60 + m;
    }
}