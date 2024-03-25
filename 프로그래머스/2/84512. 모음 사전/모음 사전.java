class Solution {
    char[] w = {'A', 'E', 'I', 'O', 'U'};
    int cnt = 0;
    boolean exitFlag = false;
    public int dfs(String makingWord, String word){
        if (makingWord.equals(word)){
            exitFlag = true;
            return cnt;
        } 
        if (makingWord.length() > 5) {
            return -1;
        }
        cnt++;
        for (int i=0;i<5;i++){
            dfs(makingWord + w[i], word);
            if (exitFlag) break;
        }
        return cnt;
    }
    
    public int solution(String word) {
        int answer = 0;
        answer = dfs("", word);
        
        return answer;
        
    }
}