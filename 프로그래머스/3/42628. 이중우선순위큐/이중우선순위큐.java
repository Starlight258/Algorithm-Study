import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqReverse = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation:operations){
            String[] splited = operation.split(" ");
            String command = splited[0];
            int number = Integer.parseInt(splited[1]);
            if (command.equals("I")){
                pq.offer(number);
                pqReverse.offer(number);
            } else if (command.equals("D")){
                if (pq.isEmpty()){
                    continue;
                }
                if (number == 1){ // 최댓값 삭제
                    int n = pqReverse.poll();
                    pq.remove(n);
                } else {
                    int n = pq.poll();
                    pqReverse.remove(n);
                }
            }
        }
        if (pq.isEmpty()){
            return new int[]{0,0};
        }
        int max = pqReverse.poll();
        int min = pq.poll();
        
        return new int[]{max, min};
    }
}