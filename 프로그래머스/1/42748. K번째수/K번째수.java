import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<commands.length;i++){
            int[] command = commands[i];
            int s = command[0]-1;
            int e = command[1]-1;
            int k = command[2]-1;
            for (int pos=s;pos<=e;pos++) list.add(array[pos]);
            Collections.sort(list);
            answer[i] = list.get(k);
            list.clear();
        }
        return answer;
    }
}