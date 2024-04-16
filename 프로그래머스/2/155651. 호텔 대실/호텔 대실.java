import java.util.*;

class Solution {
    class Reservation implements Comparable<Reservation>{
        int start;
        int end;
        Reservation(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Reservation r){
            return this.start - r.start;
        }
    }
    public int calculateTime(String inputTime){
        String[] splitTime = inputTime.split(":");
        int time = Integer.parseInt(splitTime[0]) * 60;
        time += Integer.parseInt(splitTime[1]);
        return time;
    }

    public int solution(String[][] book_time) {
        ArrayList<Reservation> list = new ArrayList<Reservation>();
        for (String[] bt:book_time){
            int startTime = calculateTime(bt[0]);
            int endTime = calculateTime(bt[1]);
            list.add(new Reservation(startTime, endTime));
        }
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int cnt = 0;
        for (Reservation r:list){
            if (pq.isEmpty()){
                pq.add(r.end + 10);
                cnt++;
            } 
            else if (!pq.isEmpty() && pq.peek() > r.start){
                pq.add(r.end+10);
                cnt++;
            }
            else {
                pq.poll();
                pq.add(r.end+10);
            }
        }
        return cnt;
    }
}