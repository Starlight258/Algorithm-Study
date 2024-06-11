class Solution {
    boolean[] visited = new boolean[54];
    boolean checkOne(String a, String b){
        int cnt = 0;
        for (int i=0;i<a.length();i++){
            if (a.charAt(i) != b.charAt(i)) cnt++;
            if (cnt>1) return false;
        }
        return true;
    }
    int dfs(int changeCnt, int now, String target, String[] words){
        visited[now] = true;
        int returnValue = Integer.MAX_VALUE;
        if (target.equals(words[now])) return changeCnt;
        if (changeCnt>= words.length) return 0;
        for (int i=0;i<words.length;i++){
            if (!visited[i] && checkOne(words[i], words[now])){
                visited[i] = true;
                returnValue = Math.min(returnValue, dfs(changeCnt+1, i, target, words));
                visited[i] = false;
            }
        }
        return returnValue;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        for (int i=0;i<words.length;i++){
            if (checkOne(begin, words[i])){
                answer = Math.min(answer, dfs(1, i, target, words));
            }
        }
        return answer;
    }
}