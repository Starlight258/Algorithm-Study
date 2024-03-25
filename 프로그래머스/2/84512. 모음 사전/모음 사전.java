class Solution {
    char[] w = {'A', 'E', 'I', 'O', 'U'};
    int cnt = 0;
    boolean exitFlag = false;
    public int dfs(String makingWord, String word, int depth){
        if (makingWord.equals(word)){
            exitFlag = true;
            return cnt;
        } 
        cnt++;
        if (makingWord.length() >= 5) {
            return -1;
        }
        for (int i=0;i<5;i++){
            dfs(makingWord + w[i], word, depth+1);
            if (makingWord.length()>=5) break;
            if (exitFlag) break;
        }
        return cnt;
    }
    
    public int solution(String word) {
        int answer = 0;
        answer = dfs("", word, 0);
        
        return answer;
        
    }
}