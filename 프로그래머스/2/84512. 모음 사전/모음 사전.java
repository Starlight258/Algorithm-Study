class Solution {
    char[] w = {'A', 'E', 'I', 'O', 'U'};
    int cnt = 0;
    boolean exitFlag = false;
    public int dfs(StringBuilder makingWord, String word){
        if (makingWord.toString().equals(word)){
            exitFlag = true;
            return cnt;
        } 
        
        if (makingWord.length() > 5) {
            return -1;
        }
        
        cnt++;
        
        for (int i=0;i<5;i++){
            dfs(makingWord.append(w[i]), word);
            makingWord.deleteCharAt(makingWord.length()-1);
            if (exitFlag) break;
        }
        
        return cnt;
    }
    
    public int solution(String word) {
        int answer = 0;
        answer = dfs(new StringBuilder(), word);
        
        return answer;
        
    }
}