import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i=0;i<commands.length;i++){
            int[] command = commands[i];
            int s = command[0];
            int e = command[1];
            int k = command[2];
            int[] temp = Arrays.copyOfRange(array, s-1, e);
            Arrays.sort(temp);
            answer[i] = temp[k-1];
        }
        return answer;
    }
}