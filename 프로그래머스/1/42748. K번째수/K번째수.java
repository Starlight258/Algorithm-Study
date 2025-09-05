import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // 2 3 5 6
        for (int i=0;i<commands.length;i++){
            int[] command = commands[i];
            int s = command[0]-1;
            int e = command[1]-1;
            int index = command[2]-1;
            List<Integer> list = new ArrayList<>();
            for (int j=s;j<=e;j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(index);
        }
        
        return answer;
    }
}