import java.util.*;

class Solution {
    static class Node {
        String w; int d;
        Node(String w, int d){ this.w = w; this.d = d; }
    }

    public int solution(String begin, String target, String[] words) {
        // (옵션) target 존재 체크
        boolean hasTarget = false;
        for (String w : words) if (w.equals(target)) hasTarget = true;
        if (!hasTarget) return 0;

        boolean[] visited = new boolean[words.length];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.w.equals(target)) return cur.d;

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                if (isAdj(cur.w, words[i])) {
                    visited[i] = true;                 // enqueue 시점에 방문 체크
                    q.offer(new Node(words[i], cur.d + 1));
                }
            }
        }
        return 0;
    }

    private boolean isAdj(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++diff > 1) return false;
        }
        return diff == 1;
    }
}