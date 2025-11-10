import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> ascPq = new PriorityQueue();
        PriorityQueue<Integer> descPq = new PriorityQueue(Collections.reverseOrder());
        for (String operation:operations){
            String[] os = operation.split(" ");
            String command = os[0];
            int value = Integer.parseInt(os[1]);
            if (command.equals("I")){
                ascPq.offer(value);    
                descPq.offer(value);
            }
            if (command.equals("D")){
                if (ascPq.isEmpty()){
                    continue;
                }
                if (value==-1){ // 최솟값 삭제 
                    int node = ascPq.poll();
                    descPq.remove(node);
                }
                if (value==1){ // 최댓값 삭제
                    int node = descPq.poll();
                    ascPq.remove(node);
                }
            }            
        }
        int least = 0;
        int maxest = 0;
        if (!ascPq.isEmpty()){
            least = ascPq.poll();
            maxest = descPq.poll();
        }
        return new int[]{maxest, least};
    }
    // D 1 : 최댓값 삭제
    // D -1 : 최솟값 삭제 
    // I 숫자 : 숫자 삽입
    // 비어있으면 [0,0], 비어있지 않으면 [최댓값, 최솟값]
    // 정렬 
    // 최댓값 정렬 큐
    // 최솟값 정렬 큐
}