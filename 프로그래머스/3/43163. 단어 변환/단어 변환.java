import java.util.*;

class Solution {
    class Node {
        String w;
        int d;
        
        Node(String w, int d){
            this.w = w;
            this.d = d;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean hasTarget = false;
        for (String word:words){
            if (word.equals(target)){
                hasTarget = true;
                break;
            }
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.w.equals(target)){
                return node.d;
            }
            for (int i=0;i<words.length;i++){
                if (visited[i]) continue;
                String word = words[i];
                if (isAdj(node.w, word)){
                  queue.offer(new Node(word, node.d+1));
                  visited[i] = true;
              }
            }
        }
        
        return answer;
    }
    private boolean isAdj(String w1, String w2){
        int diff = 0;
        for (int i=0;i<w1.length();i++){
            if (w1.charAt(i) != w2.charAt(i)){
                diff++;
            }
            if (diff>2){
                return false;
            }
        }
        if (diff==1){
            return true;
        }
        return false;
    }
}