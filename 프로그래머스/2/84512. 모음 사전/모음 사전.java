class Solution {
    char[] wordArray= {'A', 'E', 'I', 'O', 'U'};
    int count = 0;
    boolean flag = false;
    int dfs(StringBuilder word, String target){
        if (word.length()>5) return -1; 
        if (word.toString().equals(target)){
            flag = true;
            return count;
        } 
        count++;
        for (int i=0;i<5 && !flag;i++){
            dfs(word.append(wordArray[i]), target);
            word.deleteCharAt(word.length()-1);
        }
        return count;
    }
    public int solution(String target) {
        int answer = 0;
        answer = dfs(new StringBuilder(), target);
        return answer;
    }
}