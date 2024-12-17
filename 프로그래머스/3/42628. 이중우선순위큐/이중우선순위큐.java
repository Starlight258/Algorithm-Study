import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
        for (String operation:operations){
            String[] split = operation.split(" ");
            String command = split[0];
            int number = Integer.parseInt(split[1]);
            switch (command){
                case "I":
                    queue1.offer(number);
                    break;
                case "D":
                    if (queue1.isEmpty()) continue;
                    if (number==1){ // 최대값 삭제
                        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());
                        queue2.addAll(queue1);
                        int num = queue2.poll();
                        queue1.clear();
                        queue1.addAll(queue2);
                    } else { // 최소값 삭제
                        int num = queue1.poll();
                    }
                }
            }
        if (queue1.isEmpty()){
            return new int[]{0,0};
        }
        int maxNum = Collections.max(queue1);
        int minNum = Collections.min(queue1);
        return new int[]{maxNum, minNum};
    }
}